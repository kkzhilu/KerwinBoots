package com.boot.pool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/6/11 15:19
 * description:  Thread Pool App
 * version:      V1.0
 * ******************************
 */
@RestController
public class ThreadPoolApp {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @RequestMapping("/test")
    public String test() {
        threadPoolExecutor.execute(() -> System.out.println("Hello World!"));
        return "this the value of the method return";
    }
}
