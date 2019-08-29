package com.bootstarter;

import com.bootstarter.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/29 10:33
 * description:  自动注入类
 * version:      V1.0
 * ******************************
 */
@Configuration
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    /***
     * 注意：构建SpringBoot项目时候会自动增加plugin 工具，starter 不需要boot启动类
     * 如果install 时报错和工具相关，需要删除plugin相关配置
     */

    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean(StarterService.class)
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    StarterService starterService (){
        StarterService starterService = new StarterService();
        starterService.setConfig(properties.getConfig());
        return starterService;
    }
}
