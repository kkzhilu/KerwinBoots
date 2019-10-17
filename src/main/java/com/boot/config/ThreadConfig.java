package com.boot.config;

import com.boot.thread.handle.Context;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 16:19
 * description:  ThreadConfig
 * version:      V1.0
 * ******************************
 */
@Configuration
public class ThreadConfig {

    // 线程池
    private ExecutorService service;

    // 阻塞队列
    private BlockingQueue<Context> queue;

    public ThreadConfig () {

        // 初始化线程池 可以自定配置或者用更合适的都可以
        service = Executors.newFixedThreadPool(11);

        // 初始化阻塞队列 可以更换更合适的
        queue = new LinkedBlockingQueue<>();
    }

    public ExecutorService getService() {
        return service;
    }

    public BlockingQueue<Context> getQueue() {
        return queue;
    }
}
