package com.boot;

import com.boot.util.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KerwinBootsApplication.class)
public class ApplicationTests {

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    // 数据
    List<Map<String, Object>> dataList = new ArrayList<>();

    @Before
    public void initData() {
        for (int i = 1; i <= 3; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("orderId", i);
            map.put("money", 30 + (int) (Math.random() * 20));
            map.put("time", "2018-05-12");
            map.put("key", "order:" + i);
            dataList.add(map);
        }
    }

    @Test
    public void hmset () {
        for (Map<String, Object> map : dataList) {
            RedisUtil.hmset(map.get("key").toString(), map);
        }
    }

    @Test
    public void lpush () {
        for (Map<String, Object> map : dataList) {
            redisTemplate.opsForList().leftPush("user:1:order", map.get("key"));
        }

    }

    @Test
    public void appendHash () {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", 4);
        map.put("money", 30 + (int) (Math.random() * 20));
        map.put("time", "2018-01-01");
        map.put("key", "order:" + 4);
        RedisUtil.hmset(map.get("key").toString(), map);
    }

    @Test
    public void appendSet () {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", 4);
        map.put("money", 30 + (int) (Math.random() * 20));
        map.put("time", "2018-01-01");
        map.put("key", "order:" + 4);
        dataList.add(map);
        redisTemplate.opsForList().rightPush("user:1:order", dataList.get(3).get("key").toString());
    }

    @Test
    public void findOrder () {
        List<Object> range = redisTemplate.opsForList().range("user:1:order", 0, -1);
        System.out.println(range);
        for (Object o : range) {
            String key = o.toString();
            Map<Object, Object> hmget = RedisUtil.hmget(key);
            System.out.println(hmget);
        }
    }
}
