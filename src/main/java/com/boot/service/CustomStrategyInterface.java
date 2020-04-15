package com.boot.service;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/4/15 9:29
 * description:  自定义策略接口
 * version:      V1.0
 * ******************************
 */
public interface CustomStrategyInterface {

    /***
     * 默认方法
     */
    default void defaultMethod () {
        System.out.println("This is Default Method, Current Class is: " + this.getClass().getSimpleName());
    }

    /***
     * handle方法
     */
    void handle();
}
