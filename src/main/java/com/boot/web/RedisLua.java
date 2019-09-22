package com.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/22 19:49
 * description:  Redis Lua
 * version:      V1.0
 * ******************************
 */
@RestController
public class RedisLua {

    @Resource
    Jedis jedis;

    @RequestMapping("/testLua")
    public String testLua () {

        String key   = "mylock";
        String value = "xxxxxxxxxxxxxxx";

//        if redis.call('get', KEYS[1]) == ARGV[1]
//            then
//                return redis.call('del', KEYS[1])
//        else
//            return 0
//        end

        // lua脚本，用来释放分布式锁 - 如果使用的较多，可以封装到文件中, 再进行调用
        String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object eval = jedis.eval(luaScript, Collections.singletonList(key), Collections.singletonList(value));
        return eval.toString();
    }
}
