package com.boot.source;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 11:16
 * description:  切面编程 - 基于AOP 切换数据源
 * version:      V1.0
 * ******************************
 */
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
