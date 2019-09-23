package com.boot.meJedis;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/23 14:29
 * description:  ConfigUtil
 * version:      V1.0
 * ******************************
 */
public class ConfigUtil {

    // Redis 指令队列
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    // public Get
    static BlockingQueue<String> getQueue() {
        return queue;
    }
}
