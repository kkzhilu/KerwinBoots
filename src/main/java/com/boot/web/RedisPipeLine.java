package com.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/26 0:09
 * description:  RedisPipeLine
 * version:      V1.0
 * ******************************
 */
@RestController
public class RedisPipeLine {

    static String[] keys = new String[5000];

    // 初始化数据
    static {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        for (int i = 0; i < keys.length; i++) {
            jedis.set("key" + i, i + "");
        }
        jedis.close();
    }

    @RequestMapping("/testLua")
    public String testLua () {

        // 方案一： for循环删除

        // 方案二:  批量删除
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Pipeline pipelined = jedis.pipelined();
        for (String key : keys) {
            pipelined.del(key);
        }

        pipelined.sync();
        jedis.close();
        return null;
    }
}
