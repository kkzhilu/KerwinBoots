package com.boot.web.model;

import org.springframework.context.ApplicationEvent;

/**
 * ******************************
 * author:       ext.kexianming
 * createTime:   2021/7/9 5:10 下午
 * description:  User
 * version:      V1.0
 * ******************************
 */
public class User extends ApplicationEvent {

    private String name;

    public User(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
