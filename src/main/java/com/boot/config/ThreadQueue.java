package com.boot.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

    /**
     * 初始化
     */
    public ThreadQueue () {
        // 线程池
        service = Executors.newFixedThreadPool(10);

        // 队列
        queue = new LinkedBlockingQueue<>();
    }

    /*****************************************************************************************
     * 注意：由于本方法执行的必要参数 queue 是本类构建的, 所以可以正常运行
     * 如果线程池初始化，立即开始执行任务，使用其他类的属性，则很有可能在 属性赋值之前调用导致空指针
     * 解决方案: @PostConstruct
     *            CommandLineRunner接口
     */
    @PostConstruct
    public void postConstruct () {
        // 创造工作线程读取度列
        service.execute(() -> {
            try {
                readQueue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
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
