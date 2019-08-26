package com.boot.service;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/26 17:17
 * description:  异步业务层
 * version:      V1.0
 * ******************************
 */
public interface AsyncService {

    /***
     * 执行方法
     */
    void excecute() throws InterruptedException;
}
