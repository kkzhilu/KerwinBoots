package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/26 17:30
 * description:  线程池配置类
 * version:      V1.0
 * ******************************
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService fixedPool() {
        return Executors.newFixedThreadPool(5);
    }
}
