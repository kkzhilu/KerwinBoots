package com.boot.config;

import com.boot.pojo.CodeFile;
import com.boot.service.CodeFileImpl;
import com.boot.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/30 15:53
 * description:  FileQueuePool
 * version:      V1.0
 * ******************************
 */
@Component
public class FileQueuePool {

    @Autowired
    CodeFileImpl codeFileImpl;

    private static Logger logger = LoggerFactory.getLogger(FileQueuePool.class);

    /** 任务队列 **/
    private LinkedBlockingQueue<CodeFile> blockingQueue;

    /** 线程池 **/
    private ExecutorService service;

    @PostConstruct
    private void init () {
        blockingQueue = new LinkedBlockingQueue<>();

        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 获取队列任务
                        CodeFile codeFile = getBlockingQueue().take();
                        logger.info("get task from queue: file name is -> {}, path is -> {}", codeFile.getFileName(), codeFile.getPath());

                        // 读取文件内容
                        String fileContent = FileUtils.getFileContent(codeFile.getPath());
                        codeFile.setContent(fileContent);

                        // 插入到SQL中
                        boolean result = codeFileImpl.insert(codeFile);
                    } catch (Exception e) {
                        logger.error(e.getMessage(), new Throwable(e));
                    }
                }
            }
        });
    }

    public LinkedBlockingQueue<CodeFile> getBlockingQueue() {
        return blockingQueue;
    }

    public ExecutorService getService() {
        return service;
    }
}
