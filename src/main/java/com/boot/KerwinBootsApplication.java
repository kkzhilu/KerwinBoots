package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
