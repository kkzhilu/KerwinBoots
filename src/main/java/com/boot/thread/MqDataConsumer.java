package com.boot.thread;

import com.boot.config.ThreadConfig;
import com.boot.thread.handle.Context;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 16:18
 * description:  MqDataProvider 数据提供者
 * version:      V1.0
 * ******************************
 */
@Component
public class MqDataConsumer {

    @Resource
    ThreadConfig threadConfig;

    public MqDataConsumer() {
        new Runnable(){
            @Override
            public void run() {

                BlockingQueue<Context> queue = threadConfig.getQueue();

                ExecutorService service = threadConfig.getService();
                while (true) {
                    try {
                        // 从队列中拿任务
                        Context context = queue.take();
                        service.submit(() -> {
                            while (context.getFlag()) {
                                context.handle();
                            }
                        });
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
    }
}
