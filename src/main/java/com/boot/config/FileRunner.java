package com.boot.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/29 14:56
 * description:  FileConfig 读取文件目录形式 -> 以json存储
 * version:      V1.0
 * ******************************
 */
@Component
public class FileRunner implements ApplicationRunner {

    @Value("${file.path}")
    String filePath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 根JSON
        JSONObject rootJson = new JSONObject();

        File rootFile = new File(filePath);
    }

    /***
     * 读取指定目录文件 构建树形结构
     * @param file     指定文件目录
     * @param array    JSONArray
     * @return         JSONArray
     */
    private JSONArray getAllFiles (File file, JSONArray array) {
        File[] files = file.listFiles();
        for (File current : files) {
            if (current.isDirectory()) {
                JSONObject json = new JSONObject();
                json.put("uuid", UUID.randomUUID());
                json.put("label", current.getName());
                json.put("children", getAllFiles(current, new JSONArray()));
                array.add(json);
            } else {
                JSONObject json = new JSONObject();
                json.put("uuid", UUID.randomUUID());
                json.put("label", current.getName());
                array.add(json);
            }
        }
        return array;
    }
}
