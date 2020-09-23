package com.bootstarter.service;

import org.springframework.util.StringUtils;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/29 10:31
 * description:  字符串分割Service
 * version:      V1.0
 * ******************************
 */
public class StarterService {

    public String[] split(String separatorChar) {
        return StringUtils.split(this.config, separatorChar);
    }

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
