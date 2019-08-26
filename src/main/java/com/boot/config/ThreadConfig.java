package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/26 17:19
 * description:  线程池配置类 TaskExecutor类型 -> 配合Async使用
 * version:      V1.0
 * ******************************
 */
@Configuration
@EnableAsync
public class ThreadConfig {

    // bean name -> taskExecutor
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 设置核心线程数
        executor.setCorePoolSize(5);

        // 设置最大线程数
        executor.setMaxPoolSize(10);

        // 设置队列容量
        executor.setQueueCapacity(20);

        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);

        // 设置默认线程名称
        executor.setThreadNamePrefix("boot-");

        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
