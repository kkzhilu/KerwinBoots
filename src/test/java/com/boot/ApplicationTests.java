package com.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KerwinBootsApplication.class)
public class ApplicationTests {

    @Resource
    JedisPool jedisPool;

    @Test
    public void testJedis () {
        Jedis jedis = jedisPool.getResource();
        jedis.set("year", String.valueOf(24));
    }
}
