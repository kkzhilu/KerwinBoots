# SpringBoot配置多数据源

## 核心技术点



​        在Spring 2.x 中引入了AbstractRoutingDataSource, 该类充当了**DataSource的路由中介**, 能有在**运行时**, 根据某种key值来**动态切换**到真正的DataSource上。

​        Spring动态配置多数据源，即在大型应用中对数据进行切分，并且采用多个数据库实例进行管理，这样可以有效提高系统的水平伸缩性。而这样的方案就会不同于常见的单一数据实例的方案，这就要程序在运行时根据当时的请求及系统状态来动态的决定将数据存储在哪个数据库实例中，以及从哪个数据库提取数据。

​        Spring2.x的版本中采用Proxy模式，就是我们在方案中实现一个虚拟的数据源，并且用它来**封装数据源选择逻辑**，这样就可以有效地将数据源选择逻辑从Client中分离出来。Client**提供选择所需的上下文**（因为这是Client所知道的），由虚拟的DataSource根据Client提供的上下文来实现数据源的选择。 

```具体的实现如下```

```java
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        // TODO
        // 重写 determineCurrentLookupKey 方法
    }
}

```



原理:

```java
// AbstractRoutingDataSource 类
protected DataSource determineTargetDataSource() {
		Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
		Object lookupKey = determineCurrentLookupKey();
		DataSource dataSource = this.resolvedDataSources.get(lookupKey);
		if (dataSource == null && (this.lenientFallback || lookupKey == null)) {
			dataSource = this.resolvedDefaultDataSource;
		}
		if (dataSource == null) {
			throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
		}
		return dataSource;
	}
```

因此分析到，如果lookupKey 为null则会走默认配置，如果没有所谓的默认配置则会报错，如果指定了数据源，则会加载指定的配置数据源



## 代码编写

### 去除默认数据源

```java
/**
 * 1.配置数据库事务
 * 2.去除JDBC 自动配置数据源
 */
@EnableTransactionManagement
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class KerwinBootsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KerwinBootsApplication.class, args);
    }
}
```



### 多数据源配置

```java
// 多数据源配置

# select 库
spring.datasource.select.jdbc-url=jdbc:mysql://127.0.0.1:3306/test1
spring.datasource.select.driverClassName=com.mysql.jdbc.Driver
spring.datasource.select.username=root
spring.datasource.select.password=

# update 库
spring.datasource.update.jdbc-url=jdbc:mysql://127.0.0.1:3306/test2
spring.datasource.update.driverClassName=com.mysql.jdbc.Driver
spring.datasource.update.username=root
spring.datasource.update.password=
```



### 配置数据源Bean

```java
@Configuration
public class DataSourceConfig {

    // application.properteis中对应属性的前缀
    @Bean(name = "selectDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.select")
    public DataSource selectDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "updateDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.update")
    public DataSource updateDataSource() {
        return DataSourceBuilder.create().build();
    }
}
```



### 构造线程数据源持有者

```java
final class DataSourceContextHolder {

    /***
     * ThreadLocal提供了线程内存储变量的能力，这些变量不同之处在于每一个线程读取的变量是对应的互相独立的
     * 通过get和set方法就可以得到当前线程对应的值
     */
    private static ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    static void setDbType(String dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    static String getDbType() {
        return CONTEXT_HOLDER.get();
    }

    static void clear() { CONTEXT_HOLDER.remove();}
}
```



### 复写路由方法

```java
@Component
@Primary // 自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private static Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    @Autowired
    @Qualifier("selectDataSource")
    private DataSource selectDataSource;

    @Autowired
    @Qualifier("updateDataSource")
    private DataSource updateDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("切换数据源: " + DataSourceContextHolder.getDbType());
        return DataSourceContextHolder.getDbType();
    }

    /**
     * 重写after配置方法, 配置默认数据源
     */
    @Override
    public void afterPropertiesSet() {
        Map<Object,Object> map = new HashMap<>();
        map.put("selectDataSource", selectDataSource);
        map.put("updateDataSource", updateDataSource);
        setTargetDataSources(map);
        setDefaultTargetDataSource(updateDataSource);
        super.afterPropertiesSet();
    }
}
```



### 考虑自动切换数据源方案 - AOP （注解或依据方法名）

```java
@Aspect
@Component
@Order(0) // Order设定AOP执行顺序 使之在数据库事务上先执行
public class DynamicDataSourceAspect {

    @Before("execution(* com.boot.service.*.*(..))")
    public void processMethodName (JoinPoint joinPoint) {
        String methodName=joinPoint.getSignature().getName();
        if (methodName.startsWith("get")
                ||methodName.startsWith("count")
                ||methodName.startsWith("find")
                ||methodName.startsWith("list")
                ||methodName.startsWith("select")
                ||methodName.startsWith("check")){
            DataSourceContextHolder.setDbType("selectDataSource");
        }else {
            //切换dataSource
            DataSourceContextHolder.setDbType("updateDataSource");
        }
    }

//    @Before("execution(* com.boot.service.*.*(..))")
//    public void process(JoinPoint point) {
//
//        //获得当前访问的class
//        Class<?> className = point.getTarget().getClass();
//
//        //获得访问的方法名
//        String methodName = point.getSignature().getName();
//
//        //得到方法的参数的类型
//        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
//
//        try {
//            // 得到访问的方法对象
//            Method method = className.getMethod(methodName, argClass);
//
//            // 判断是否存在@DS注解
//            if (method.isAnnotationPresent(DS.class)) {
//                DS annotation = method.getAnnotation(DS.class);
//
//                // 取出注解中的数据源名
//                String dataSource = annotation.value();
//
//                // 切换数据源
//                DataSourceContextHolder.setDbType(dataSource);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("error.");
//        }
//    }

    @After("execution(* com.boot.service.*.*(..))")
    public void afterswitchDs (JoinPoint point){
        DataSourceContextHolder.clear();
    }
}
```



## 遗留技术点

### ThreadLocal 的作用，DataSourceContextHolder类的意义何在

作用：建立一个获得和设置上下文环境的类，主要负责改变上下文数据源的名称

原因：ThreadLocal 与 Synchronized 作用不同 -》

Synchronized  -> 保证多线程情况下变量一致性（数据共享）

ThreadLocal    -> 保证多线程情况下变量私有性（数据隔离）

即每个线程的变量只对自己本线程负责 （不会存在A线程改了影响B的情况，要的就是数据隔离）



官方解释:

```
This class provides thread-local variables. These variables differ from their normal counterparts in that each thread that accesses one (via its {@code get} or {@code set} method) has its own, independently initialized copy of the variable. {@code ThreadLocal} instances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or Transaction ID).
```

总结:

> 总结一下重点：
>
> - ThreadLocal 提供了一种访问某个变量的特殊方式：访问到的变量属于当前线程，即保证每个线程的变量不一样，而同一个线程在任何地方拿到的变量都是当前这个线程私有的，这就是所谓的线程隔离。
> - 如果要使用 ThreadLocal，通常定义为 private static 类型，最好是定义为 private static final 类型。



### 2.为什么重写了 determineCurrentLookupKey 方法，SpringBoot真正在执行的时候就会调用我们重写的类呢？

```
AbstractAutowireCapableBeanFactory.invokeInitMethods
```

猜测: SpringBoot中有很多Conditional... 条件注入的方式，可能是由于符合某种条件，因此将该bean作为真正的实现类进行调用，因为在正常的单数据源项目中无相关的bean且该抽象类也并没有被断点捕获到调用，如果以后有更加细致的发现，再来补充吧。