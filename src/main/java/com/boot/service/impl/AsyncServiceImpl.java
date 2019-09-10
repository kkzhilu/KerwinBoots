package com.boot.service.impl;

import com.boot.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/26 17:18
 * description:  实现层
 * version:      V1.0
 * ******************************
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Async
    @Override
    public void excecute() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " has finish!");
    }

    @Async
    @Override
    public Future<String> excecuteForValue(CountDownLatch countDownLatch) throws InterruptedException {
        double num = Math.random() * 100;
        Thread.sleep(2000);
        countDownLatch.countDown();
        return new AsyncResult<>(String.valueOf(num));
    }

    @Override
    public void testThreads() {
        logger.error("Service Time: " + System.currentTimeMillis());
    }
}
