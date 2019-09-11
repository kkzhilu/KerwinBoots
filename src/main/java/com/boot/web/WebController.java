package com.boot.web;

import com.boot.bean.TestBean;
import com.boot.service.RedisServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/11 16:54
 * description:  TODO
 * version:      V1.0
 * ******************************
 */
@RestController
public class WebController {

    @Resource
    RedisServiceImpl redisService;

    @RequestMapping("/testBeanAnnotation")
    public TestBean testBeanAnnotation () {
        return redisService.testBeanAnnotation();
    }
}
