package com.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/20 10:47
 * description:  TODO
 * version:      V1.0
 * ******************************
 */
@RestController
public class RedisLock {

    @Resource
    Jedis jedis;

    // 设置锁
    // 业务处理
    // 解锁
    @RequestMapping("/redisLock")
    public String testRedisLock () {
        Long result = jedis.setnx("KEY", UUID.randomUUID().toString());

        return "success";
    }
}
