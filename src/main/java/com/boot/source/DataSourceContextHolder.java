package com.boot.source;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 10:59
 * description:  DataSourceHolder 数据源持有者
 * version:      V1.0
 * ******************************
 */
final class DataSourceContextHolder {

    /***
     * ThreadLocal提供了线程内存储变量的能力，这些变量不同之处在于每一个线程读取的变量是对应的互相独立的
     * 通过get和set方法就可以得到当前线程对应的值
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    static void setDbType(String dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    static String getDbType() {
        return CONTEXT_HOLDER.get();
    }

    static void clear() { CONTEXT_HOLDER.remove();}
}
