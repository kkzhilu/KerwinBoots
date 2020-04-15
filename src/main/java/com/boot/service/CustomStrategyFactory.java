package com.boot.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/4/15 9:35
 * description:  策略工厂
 * version:      V1.0
 * ******************************
 */
@Component
public class CustomStrategyFactory implements InitializingBean {

    @Autowired
    List<CustomStrategyInterface> interfaces;

    // MAP存储对象
    private final Map<String, CustomStrategyInterface> INTERFACES = new HashMap<>(1024);

    public Map<String, CustomStrategyInterface> getInterfaces() {
        return INTERFACES;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (CustomStrategyInterface demo : interfaces) {
            demo.handle();
            INTERFACES.put(demo.getClass().getSimpleName(), demo);
        }
    }
}
