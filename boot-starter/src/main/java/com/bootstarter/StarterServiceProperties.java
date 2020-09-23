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

    private boolean enabledExampleService;

    private boolean enabledTwoSumService;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public boolean isEnabledExampleService() {
        return enabledExampleService;
    }

    public void setEnabledExampleService(boolean enabledExampleService) {
        this.enabledExampleService = enabledExampleService;
    }

    public boolean isEnabledTwoSumService() {
        return enabledTwoSumService;
    }

    public void setEnabledTwoSumService(boolean enabledTwoSumService) {
        this.enabledTwoSumService = enabledTwoSumService;
    }
}
