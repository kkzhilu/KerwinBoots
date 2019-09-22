package com.boot.web;


import com.boot.config.RedisContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.UUID;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/20 10:47
 * description:  RedisLock
 * version:      V1.0
 * ******************************
 */
@RestController
public class RedisLock {

    private static final String KEY = "KEY";

    @Resource
    Jedis jedis;

    /***
     * 核心思路：
     *     分布式服务调用时setnx,返回1证明拿到，用完了删除，返回0就证明被锁，等...
     *     SET KEY value [EX seconds] [PX milliseconds] [NX|XX]
     *     EX second:设置键的过期时间为second秒
     *     PX millisecond:设置键的过期时间为millisecond毫秒
     *     NX：只在键不存在时，才对键进行设置操作
     *     XX:只在键已经存在时，才对键进行设置操作
     *
     * 1.设置锁
     *     A. 分布式业务统一Key
     *     B. 设置Key过期时间
     *     C. 设置随机value,利用ThreadLocal 线程私有存储随机value
     *
     * 2.业务处理
     *     ...
     *
     * 3.解锁
     *     A. 无论如何必须解锁 - finally (超时时间和finally 双保证)
     *     B. 要对比是否是本线程上的锁，所以要对比线程私有value和存储的value是否一致(避免把别人加锁的东西删除了)
     */
    @RequestMapping("/redisLock")
    public String testRedisLock () {
        try {
            for(;;){
                RedisContextHolder.clear();
                String uuid = UUID.randomUUID().toString();

                String set = jedis.set(KEY, uuid, "NX", "EX", 1000);
                RedisContextHolder.setValue(uuid);

                if (!"OK".equals(set)) {
                    // 进入循环-可以短时间休眠
                } else {
                    // 获取锁成功 Do Somethings....
                    break;
                }
            }
        } finally {
            // 解锁 -> 保证获取数据，判断一致以及删除数据三个操作是原子的， 因此如下写法是不符合的
            /*if (RedisContextHolder.getValue() != null && jedis.get(KEY) != null && RedisContextHolder.getValue().equals(jedis.get(KEY))) {
                jedis.del(KEY);
            }*/

            // 正确姿势 -> 使用Lua脚本,保证原子性
            String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
            Object eval = jedis.eval(luaScript, Collections.singletonList(KEY), Collections.singletonList(RedisContextHolder.getValue()));
        }
        return "锁创建成功-业务处理成功";
    }
}
