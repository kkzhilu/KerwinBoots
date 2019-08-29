package com.boot.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/29 14:56
 * description:  FileConfig 读取文件目录形式 -> 以json存储
 * version:      V1.0
 * ******************************
 */
@Component
public class FileConfig implements ApplicationRunner {

    @Value("${file.path}")
    String filePath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 根JSON
        JSONObject rootJson = new JSONObject();

        File rootFile = new File(filePath);
    }
}
