package com.bootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/29 10:32
 * description:  Starter 配置类
 * version:      V1.0
 * ******************************
 */
@ConfigurationProperties("example.service")
public class StarterServiceProperties {

    private String config;

    private boolean enabled;

    public void setConfig(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
