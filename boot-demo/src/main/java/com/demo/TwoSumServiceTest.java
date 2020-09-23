package com.demo;

import com.bootstarter.service.TwoNumSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
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
@ConditionalOnExpression("${example.service.enabled-two-sum-service:true}")
public class TwoSumServiceTest implements ApplicationRunner {

    @Autowired
    private TwoNumSumService twoNumSumService;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(Arrays.toString(twoNumSumService.twoSum(new int[]{1, 2, 5, 6, 8}, 11)));
    }
}
