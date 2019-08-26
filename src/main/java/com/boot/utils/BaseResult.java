package com.boot.utils;

import java.io.Serializable;

/**
 * ******************************
 * Author：      柯贤铭
 * CreateTime:   2019/3/4 20:23
 * Description:  返回结果
 * Version:      V1.0
 * ******************************
 */
public class BaseResult<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 数据
     */
    private T data;

    /**
     * 错误信息
     */
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public BaseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
