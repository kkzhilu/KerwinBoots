package com.boot.web;

import com.boot.bean.TestBean;
import com.boot.util.RedisUtil;
import com.boot.service.RedisServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/11 16:54
 * description:  TODO
 * version:      V1.0
 * ******************************
 */
@RestController
public class WebController {

    @Resource
    RedisServiceImpl redisService;

    @RequestMapping("/testBeanAnnotation")
    public TestBean testBeanAnnotation () {
        return redisService.testBeanAnnotation();
    }

    @RequestMapping("/testRedis")
    public TestBean testRedis () {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "every things.");
        RedisUtil.hmset("aaa",map);
        System.out.println(RedisUtil.hget("aaa", "key"));
        return new TestBean();
    }

    AtomicLong atomicLong = new AtomicLong(0);

    @RequestMapping("/safe")
    public TestBean safe () {
        RedisUtil.incr("LOCK", 1L);
        System.out.println(atomicLong.addAndGet(1));
        return new TestBean();
    }
}
