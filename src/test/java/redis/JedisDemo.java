package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/5/27 16:40
 * description:  JedisPushData
 * version:      V1.0
 * ******************************
 */
public class JedisDemo {

    static final String KEY = "RANDOM_LIST";

    static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxWaitMillis(3000L);
        int timeOut = 3000 * 10;
        jedisPool = new JedisPool(jedisPoolConfig, "10.10.210.20", 6379, timeOut);
    }

    public static void push () {
        Jedis jedis = jedisPool.getResource();
        String[] strings = new String[8500];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "Demo-" + i;
        }

        Long rpush = jedis.rpush(KEY, strings);
        System.out.println(rpush);
    }

    public static void remove () {
        Jedis jedis = jedisPool.getResource();
        Long length = jedis.llen(KEY);
        if (null != length && length > 0) {
            System.out.println("Length: " + length);

            long curr = 0L;
            while (curr < length) {
                List<String> list = jedis.lrange(KEY, 0, 500L);
                for (String s : list) {
                    jedis.lrem(KEY, 1, s);
                }
                curr += 500L;
                System.out.println("Curr: " + curr);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(JedisDemo::remove).start();
        Thread.sleep(100);
        //new Thread(JedisDemo::push).start();
    }
}
