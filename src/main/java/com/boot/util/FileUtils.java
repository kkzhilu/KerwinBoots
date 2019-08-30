package com.boot.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boot.config.FileQueuePool;
import com.boot.pojo.CodeFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/30 16:01
 * description:  FileUtils
 * version:      V1.0
 * ******************************
 */
@Component
public class FileUtils {

    // 注入到static 对象中
    private static FileQueuePool fileQueuePool;

    @Autowired
    public void setFileQueuePool (FileQueuePool fileQueuePool) {
        FileUtils.fileQueuePool = fileQueuePool;
    }

    /**
     * 获取文件内容
     */
    public static String getFileContent (String filePath) throws IOException {
        BufferedReader buf = new BufferedReader(new FileReader(filePath));
        StringBuilder sbuf = new StringBuilder();
        String line;

        boolean flag = true;
        while ((line = buf.readLine()) != null) {
            if (flag) {
                sbuf.append(line);
                flag = false;
            } else {
                sbuf.append("\n").append(line);
            }
        }
        buf.close(); // 读取结束
        return sbuf.toString();
    }

    /***
     * 读取指定目录文件 构建树形结构
     * @param file     指定文件目录
     * @param array    JSONArray
     * @return         JSONArray
     */
    public static JSONArray getAllFiles (File file, JSONArray array) {
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

                CodeFile codeFile = new CodeFile();
                codeFile.setUuid(json.getString("uuid"));
                codeFile.setFileName(json.getString("label"));
                codeFile.setPath(current.getAbsolutePath());
                codeFile.setFileType(current.getName().endsWith("java") ? "java" : "other");

                // 加入到任务队列中 - 读取文件内容
                fileQueuePool.getBlockingQueue().offer(codeFile);
                array.add(json);
            }
        }
        return array;
    }
}
