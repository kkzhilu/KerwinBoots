package com.boot.web;

import com.boot.annotation.RateLimiterAnno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRequest {

    @RateLimiterAnno(value = 1.0, timeout = 300)
    @RequestMapping("/test1")
    public String test1() {
        logger.info("【test1】被执行了。。。。。");
        return "ok";
    }

    @RateLimiterAnno(value = 10.0, timeout = 300)
    @RequestMapping("/test2")
    public String test3() {
        logger.info("【test2】被执行了。。。。。");
        return "ok";
    }

    private static Logger logger = LoggerFactory.getLogger(AppRequest.class);
}
