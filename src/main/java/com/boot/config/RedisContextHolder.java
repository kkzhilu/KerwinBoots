package com.boot.config;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 10:59
 * description:  ContextHolder
 * version:      V1.0
 * ******************************
 */
public class RedisContextHolder {

    /***
     * ThreadLocal提供了线程内存储变量的能力，这些变量不同之处在于每一个线程读取的变量是对应的互相独立的
     * 通过get和set方法就可以得到当前线程对应的值
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setValue(String value) {
        CONTEXT_HOLDER.set(value);
    }

    public static String getValue() {
        return CONTEXT_HOLDER.get();
    }

    public static void clear() { CONTEXT_HOLDER.remove();}
}
