package com.boot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/5/19 10:39
 * description:  注入Static变量
 * version:      V1.0
 * ******************************
 */
@Component
public class ConfigValue {

    public static String LOG_PARSE_PATH;

    public static String LOG_TMP_PATH;

    @Value("${log.parse.path}")
    public void setLogParsePath(String logParsePath) {
        LOG_PARSE_PATH = logParsePath;
    }

    @Value("${log.tmp.path}")
    public void setLogTmpPath(String logTmpPath) {
        LOG_TMP_PATH = logTmpPath;
    }
}
