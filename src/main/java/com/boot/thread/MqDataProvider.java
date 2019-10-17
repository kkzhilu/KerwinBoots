package com.boot.thread;

import com.boot.config.MqStatus;
import com.boot.pojo.DbMqDemo;
import com.boot.service.DbMQService;
import com.boot.thread.handle.CommitHandle;
import com.boot.thread.handle.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
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
public class MqDataProvider {

    @Autowired
    ExecutorService fixedPool;

    @Autowired
    BlockingQueue<Context> myqueue;

    @Resource
    DbMQService dbMQService;

    private void init () {
        fixedPool.execute(() -> {
            try {
                // 提交或者需要重试的
                List<DbMqDemo> dbMqDemos = dbMQService.selectMQ(MqStatus.HAVA_COMMIT.getStatus());
                for (DbMqDemo dbMqDemo : dbMqDemos) {
                    Context context = new Context();
                    context.setDbMqDemo(dbMqDemo);
                    context.setFlag(true);
                    context.setStatusInterface(new CommitHandle());
                    myqueue.put(context);
                }

                // 5s 拿一批任务
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public MqDataProvider () {
        init();
    }
}