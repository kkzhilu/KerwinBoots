package com.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/20 10:22
 * description:  Redis 限流 Demo
 * version:      V1.0
 * ******************************
 */
@RestController
public class RedisLimit {

    private final static Long MAX_LIMITTIME = 5L;

    @Resource
    Jedis jedis;

    @RequestMapping("/redisLimit")
    public String testRedisLimit(String uuid) {
        if (jedis.get(uuid) != null) {
            Long incr = jedis.incr(uuid);
            if (incr > MAX_LIMITTIME) {
                return "Failure Request";
            } else {
                return "Success Request";
            }
        }

        // 设置Key 起始请求为1，10秒过期  ->  实际写法肯定封装过,这里就是随便一写
        jedis.set(uuid, "1");
        jedis.expire(uuid, 10);
        return "Success Request";
    }
}
