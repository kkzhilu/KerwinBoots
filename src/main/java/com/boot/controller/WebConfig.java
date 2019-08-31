package com.boot.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/31 11:51
 * description:  WebConfig 解决跨域问题
 * version:      V1.0
 * ******************************
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")   // 表示本应用的所有方法都会去处理跨域请求
                .allowedOrigins("*")             // 例如允许：http://localhost:8081请求
                .allowedMethods("*")             // 表示允许通过的请求数
                .allowedHeaders("*")             // 表示允许通过的请求头
                .allowCredentials(true);         // 允许前端传递cookie
    }
}
