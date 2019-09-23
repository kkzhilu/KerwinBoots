package redisServer;

import redis.clients.jedis.Jedis;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/23 9:41
 * description:  App
 * version:      V1.0
 * ******************************
 */
public class App {

    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.set("key", "This is value.");
        jedis.close();
    }
}
