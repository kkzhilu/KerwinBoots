package com.demo;

import com.bootstarter.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/29 11:25
 * description:  ServiceTest 项目启动测试类
 * version:      V1.0
 * ******************************
 */
@Component
@ConditionalOnExpression("${example.service.enabled:true}")
public class ServiceTest implements ApplicationRunner {

    @Autowired
    private StarterService starterService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(Arrays.toString(starterService.split(",")));
    }
}
