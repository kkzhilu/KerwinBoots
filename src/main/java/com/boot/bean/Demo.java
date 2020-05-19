package com.boot.bean;

import org.springframework.stereotype.Component;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/5/19 10:54
 * description:  DemoBean
 * version:      V1.0
 * ******************************
 */
@Component
public class Demo {

    String getValue (String key) {
        if ("LOG_PARSE_PATH".equals(key)) {
            return ConfigValue.LOG_PARSE_PATH;
        } else {
            return ConfigValue.LOG_TMP_PATH;
        }
    }
}
