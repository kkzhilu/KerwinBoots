package com.boot.config;

import com.boot.thread.handle.Context;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 16:19
 * description:  ThreadConfig
 * version:      V1.0
 * ******************************
 */
@Component
public class ThreadConfig {

    private BlockingQueue<Context> queue;

    public ThreadConfig() {
        // 初始化阻塞队列 可以更换更合适的
        queue = new LinkedBlockingQueue<>();
    }

    public BlockingQueue<Context> getQueue() {
        return queue;
    }
}
