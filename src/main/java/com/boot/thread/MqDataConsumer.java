package com.boot.thread;

import com.boot.config.ThreadConfig;
import com.boot.thread.handle.Context;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

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

    @PostConstruct
    public void init () {
        threadConfig.getService().execute(() -> {
            while (true) {
                try {
                    // 从队列中拿任务
                    Context context = threadConfig.getQueue().take();
                    threadConfig.getService().execute(() -> {
                        while (context.getFlag()) {
                            context.handle();
                        }
                    });
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
