package com.boot.meJedis;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/23 14:42
 * description:  Me Jedis Test
 * version:      V1.0
 * ******************************
 */
public class CommandUtil {

    // Set
    public static void set(String key, String val) throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        sb.append("*3").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("SET").append("\r\n");
        sb.append("$").append(key.getBytes().length).append("\r\n");
        sb.append(key).append("\r\n");
        sb.append("$").append(val.getBytes().length).append("\r\n");
        sb.append(val).append("\r\n");

        // RESP命令加入队列中
        ConfigUtil.getQueue().put(sb.toString());
    }

    // Get
    public static void get(String key) throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        sb.append("*2").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("GET").append("\r\n");
        sb.append("$").append(key.getBytes().length).append("\r\n");
        sb.append(key).append("\r\n");

        // RESP命令加入队列中
        ConfigUtil.getQueue().put(sb.toString());
    }
}
