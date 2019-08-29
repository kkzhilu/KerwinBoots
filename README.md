# 一.Spring Boot Starter简介
Starter是Spring Boot中的一个非常重要的概念，Starter相当于模块，它能将模块所需的依赖整合起来并对模块内的Bean根据环境（ 条件）进行自动配置。使用者只需要依赖相应功能的Starter，无需做过多的配置和依赖，Spring Boot就能自动扫描并加载相应的模块。

例如在Maven的依赖中加入spring-boot-starter-web就能使项目支持Spring MVC，并且Spring Boot还为我们做了很多默认配置，无需再依赖spring-web、spring-webmvc等相关包及做相关配置就能够立即使用起来。

# 二.Starter的开发步骤
编写Starter非常简单，与编写一个普通的Spring Boot应用没有太大区别，总结如下：

    1.新建Maven项目，在项目的POM文件中定义使用的依赖；
    2.新建配置类，写好配置项和默认的配置值，指明配置项前缀；
    3.新建自动装配类，使用@Configuration和@Bean来进行自动装配；
    4.新建spring.factories文件，指定Starter的自动装配类；

# 三.Starter的开发示例
下面，我就以创建一个自动配置来讲一下各个步骤及细节。
1.新建Maven项目，在项目的POM文件中定义使用的依赖。
```xml
 <dependencies>
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-configuration-processor</artifactId>
         <optional>true</optional>
     </dependency>

     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-autoconfigure</artifactId>
     </dependency>
 </dependencies>   
```


2.新建配置类，写好配置项和默认的配置值，指明配置项前缀。
```java
@ConfigurationProperties("example.service")
public class StarterServiceProperties {

    private String config;

    private boolean enabled;

    public void setConfig(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
```
> 指定配置项前缀为`example.service`，各配置项均有默认值，默认值可以通过模块使用者的配置文件进行覆盖。

3.新建自动装配类，使用`@Configuration`和`@Bean`来进行自动装配。
```java
@Configuration
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    /***
     * 注意：构建SpringBoot项目时候会自动增加plugin 工具，starter 不需要boot启动类
     * 如果install 时报错和工具相关，需要删除plugin相关配置
     */

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean(StarterService.class)
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    StarterService starterService (){
        StarterService starterService = new StarterService();
        starterService.setConfig(properties.getConfig());
        return starterService;
    }
}
```

4.新建spring.factories文件，指定Starter的自动装配类。
```
# 配置自动注入的类
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.bootstarter.StarterAutoConfigure
```

> spring.factories文件位于resources/META-INF目录下，需要手动创建;
`org.springframework.boot.autoconfigure.EnableAutoConfiguration`后面的类名说明了自动装配类，如果有多个 ，则用逗号分开;
使用者应用（SpringBoot）在启动的时候，会通过`org.springframework.core.io.support.SpringFactoriesLoader`读取classpath下每个Starter的spring.factories文件，加载自动装配类进行Bean的自动装配；

至此，整个Starter开发完毕，Deploy到中央仓库或Install到本地仓库后即可使用

# 四.Starter的使用
1.创建Maven项目，依赖刚才发布的es-starter包。
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>

    <!-- 依赖自定义starter -->
    <dependency>
        <groupId>com</groupId>
        <artifactId>boot-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```
> 只需依赖刚才开发的es-starter即可

2.根据要求进行配置
```
# starter 配置文件
example.service.config  = abc-des-dde,SSS-DRS-RE,SDR-SDFR-XXX
example.service.enabled = false
```

3.编写应用程序启动类。
```java
// 根据example.service.enabled 参数配置是否进行自动装配
@Component
@ConditionalOnExpression("${example.service.enabled:true}")
public class ServiceTest implements ApplicationRunner {

    @Autowired
    private StarterService starterService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(Arrays.toString(starterService.split(",")));
    }
}
```


5.运行程序测试
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.7.RELEASE)

2019-08-29 14:28:27.061  INFO 9844 --- [           main] com.demo.BootDemoApplication             : Starting BootDemoApplication on Kerwin with PID 9844 (C:\Users\Administrator\Desktop\Codes\KerwinBoots\boot-demo\target\classes started by Administrator in C:\Users\Administrator\Desktop\Codes\KerwinBoots)
2019-08-29 14:28:27.064  INFO 9844 --- [           main] com.demo.BootDemoApplication             : No active profile set, falling back to default profiles: default
2019-08-29 14:28:28.317  INFO 9844 --- [           main] com.demo.BootDemoApplication             : Started BootDemoApplication in 1.733 seconds (JVM running for 2.975)
[abc-des-dde, SSS-DRS-RE,SDR-SDFR-XXX]
```
> 运行程序，观察控制台输出: 源码可见: https://github.com/kkzhilu/KerwinBoots | boot_starter 分支

| 注解                              | 说明                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| `@ConditionalOnSingleCandidate`   | 当给定类型的bean存在并且指定为Primary的给定类型存在时,返回true |
| `@ConditionalOnMissingBean`       | 当给定的类型、类名、注解、昵称在beanFactory中不存在时返回true.各类型间是or的关系 |
| `@ConditionalOnBean`              | 与上面相反，要求bean存在                                     |
| `@ConditionalOnMissingClass`      | 当给定的类名在类路径上不存在时返回true,各类型间是and的关系   |
| `@ConditionalOnClass`             | 与上面相反，要求类存在                                       |
| `@ConditionalOnCloudPlatform`     | 当所配置的CloudPlatform为激活时返回true                      |
| `@ConditionalOnExpression`        | spel表达式执行为true                                         |
| `@ConditionalOnJava`              | 运行时的java版本号是否包含给定的版本号.如果包含,返回匹配,否则,返回不匹配 |
| `@ConditionalOnProperty`          | 要求配置属性匹配条件                                         |
| `@ConditionalOnJndi`              | 给定的jndi的Location 必须存在一个.否则,返回不匹配            |
| `@ConditionalOnNotWebApplication` | web环境不存在时                                              |
| `@ConditionalOnWebApplication`    | web环境存在时                                                |
| `@ConditionalOnResource`          | 要求制定的资源存在      

