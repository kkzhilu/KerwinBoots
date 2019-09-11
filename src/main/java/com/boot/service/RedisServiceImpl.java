package com.boot.service;

import com.boot.bean.TestBean;
import com.boot.bean.TestNode;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/11 16:50
 * description:  RedisServiceImpl
 * version:      V1.0
 * ******************************
 */
@Service
public class RedisServiceImpl {

    @Cacheable(value = "redisTest")
    public TestBean testBeanAnnotation () {
        TestBean testBean = new TestBean();
        testBean.setId(1);
        testBean.setName("redis test");

        TestNode testNode = new TestNode();
        testNode.setNode("This is Node");
        testBean.setTestNode(testNode);

        System.out.println("Method is from Java Code");
        return testBean;
    }

    public TestBean testBean () {
        TestBean testBean = new TestBean();
        testBean.setId(666);
        testBean.setName("redis test no annotation");
        return testBean;
    }
}
