package com.boot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/5/19 10:40
 * description:  Config中的static Bean
 * version:      V1.0
 * ******************************
 */
@Component
public class ConfigStaticBean {

    public static Demo demo;

    @Autowired
    public void setDemo(Demo demo) {
        ConfigStaticBean.demo = demo;
    }

    public static String getValue (String key) {
       return demo.getValue(key);
    }
}
