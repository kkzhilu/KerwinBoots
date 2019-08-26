package com.boot.controller;

import com.boot.config.ThreadQueue;
import com.boot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/26 17:37
 * description:  BaseController 集中配置
 * version:      V1.0
 * ******************************
 */
@RestController
public class BaseController {

    @Resource
    AsyncService asyncService;

    @Resource
    ExecutorService fixedPool;

    @Autowired
    ThreadQueue threadQueue;
}
