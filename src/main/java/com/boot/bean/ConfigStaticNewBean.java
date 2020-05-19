package com.boot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/5/19 10:40
 * description:  Config中的static Bean 方式二
 * version:      V1.0
 * ******************************
 */
@Component
public class ConfigStaticNewBean {

    @Autowired
    private Demo demo;

    private static Demo staticDemo;

    @PostConstruct
    public void init() {
        staticDemo = demo;
    }

    public static String getValue (String key) {
        return staticDemo.getValue(key);
    }
}
