package com.boot.config;

import com.alibaba.fastjson.JSONArray;
import com.boot.pojo.RootFile;
import com.boot.service.RootFileImpl;
import com.boot.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.Map;
import java.util.Objects;
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
public class FileRunner implements CommandLineRunner {

    @Resource
    RootFileImpl rootFileImpl;

    @Value("${file.path}")
    String filePath;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            // 获取指定目录工程-map格式
            Map<String, RootFile> result = rootFileImpl.getFilesByMap();

            File file = new File(filePath);
            if (file.isDirectory() && file.exists()) {
                File[] files = file.listFiles();
                for (File current : Objects.requireNonNull(files)) {
                    // 如果不包含该工程则开始录入
                    if (!result.containsKey(current.getName())) {
                        RootFile rootFile = new RootFile();
                        rootFile.setUuid(UUID.randomUUID().toString());
                        rootFile.setFileName(current.getName());
                        rootFile.setDesc("is only test");

                        // 树形目录
                        JSONArray jsonArray = FileUtils.getAllFiles(current, new JSONArray());
                        rootFile.setContent(jsonArray.toJSONString());

                        boolean insert = rootFileImpl.insert(rootFile);
                        if (insert) {
                            logger.info("root file {}, insert successful", current.getName());
                        }
                    }
                }
            }

            // 休眠60分钟 - 用来动态的增加文件目录
            Thread.sleep(60 * 1000 * 60);
        }
    }

    private static Logger logger = LoggerFactory.getLogger(FileRunner.class);
}
