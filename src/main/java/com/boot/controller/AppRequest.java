package com.boot.controller;

import com.boot.service.AsyncService;
import com.boot.utils.BaseResult;
import com.boot.utils.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/26 17:13
 * description:  Controller请求类
 * version:      V1.0
 * ******************************
 */
@RestController
public class AppRequest extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(AppRequest.class);

    @RequestMapping("/testForAsync")
    public BaseResult testForAsync() throws InterruptedException {

        // 顺序执行三个耗时操作 - 接口则仍然瞬间响应,异步生效
        long start = System.currentTimeMillis();
        asyncService.excecute();
        asyncService.excecute();
        asyncService.excecute();
        System.out.println("time consuming is: " + (System.currentTimeMillis() - start));


        // 从线程池中拿取资源
        fixedPool.execute(()-> System.out.println(Thread.currentThread().getName() + "i am fixedPool"));

        // 测试Component Queue
        threadQueue.getQueue().offer((Math.random()) * 20 + "");

        return new BaseResult<>(ResultCode.success.getCode(), ResultCode.success.getDescr(), null);
    }

    @RequestMapping("/testForValue")
    public BaseResult testForValue() throws InterruptedException, ExecutionException {

        // 顺序执行三个耗时操作 - 接口则仍然瞬间响应,异步生效
        long start = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(3);
        Future<String> v1 = asyncService.excecuteForValue(countDownLatch);
        Future<String> v2 = asyncService.excecuteForValue(countDownLatch);
        Future<String> v3 = asyncService.excecuteForValue(countDownLatch);
        countDownLatch.await();

        System.out.println(v1.get());
        System.out.println(v2.get());
        System.out.println(v3.get());
        System.out.println("time consuming is: " + (System.currentTimeMillis() - start));
        return new BaseResult<>(ResultCode.success.getCode(), ResultCode.success.getDescr(), null);
    }

    @RequestMapping("/testThreads")
    public BaseResult testThreads() throws InterruptedException {
        asyncService.testThreads();
        Thread.sleep(200);
        logger.info("Now Time is: " + System.currentTimeMillis());
        return new BaseResult<>(ResultCode.success.getCode(), ResultCode.success.getDescr(), null);
    }
}
