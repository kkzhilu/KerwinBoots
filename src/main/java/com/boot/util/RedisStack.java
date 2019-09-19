package com.boot.util;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/19 23:30
 * description:  RedisQueue 基于Redis的栈
 * version:      V1.0
 * ******************************
 */
@Component
public class RedisStack {

    @Resource
    JedisPool jedisPool;

    private final static String KEY = "Stack";

    /** push **/
    public void push (String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.lpush(KEY, value);
    }

    /** pop **/
    public String pop () {
        Jedis jedis = jedisPool.getResource();
        return jedis.lpop(KEY);
    }
}
