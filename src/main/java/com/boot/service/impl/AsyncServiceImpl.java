package com.boot.service.impl;

import com.boot.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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

    @Async
    @Override
    public void excecute() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " has finish!");
    }
}
