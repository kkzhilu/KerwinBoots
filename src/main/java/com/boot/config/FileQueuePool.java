package com.boot.config;

import com.boot.pojo.CodeFile;
import com.boot.service.CodeFileImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
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
    CodeFileImpl codeFile;

    private static Logger logger = LoggerFactory.getLogger(FileQueuePool.class);

    /** 任务队列 **/
    private LinkedBlockingQueue<CodeFile> blockingQueue;

    /** 线程池 **/
    private ExecutorService service;

    private void init () {
        blockingQueue = new LinkedBlockingQueue<>();

        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        CodeFile codeFile = getBlockingQueue().take();




                    } catch (InterruptedException e) {
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
