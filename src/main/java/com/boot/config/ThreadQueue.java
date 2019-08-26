package com.boot.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/26 17:47
 * description:  ThreadQueue
 * version:      V1.0
 * ******************************
 */
@Component
public class ThreadQueue {

    /**
     * 线程池
     */
    private ExecutorService service;

    /***
     * 队列
     */
    private BlockingQueue<String> queue;

    public ThreadQueue () {
        init();

        // 创造工作线程读取度列
        service.execute(() -> {
            try {
                readQueue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 初始化
     */
    private void init () {
        // 线程池
        service = Executors.newFixedThreadPool(10);

        // 队列
        queue = new LinkedBlockingQueue<>();
    }

    /***
     * 读取队列
     */
    private void readQueue() throws InterruptedException {
        while (true) {
            String take = queue.take();
            System.out.println(Thread.currentThread() + "queue name is: " + take);
        }
    }

    public ExecutorService getService() {
        return service;
    }

    public void setService(ExecutorService service) {
        this.service = service;
    }

    public BlockingQueue<String> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }
}
