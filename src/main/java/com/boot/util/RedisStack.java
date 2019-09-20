package com.boot.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

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
    Jedis jedis;

    private final static String KEY = "Stack";

    /** push **/
    public void push (String value) {
        jedis.lpush(KEY, value);
    }

    /** pop **/
    public String pop () {
        return jedis.lpop(KEY);
    }
}
