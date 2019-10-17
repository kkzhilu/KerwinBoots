package com.boot.thread.handle;

import com.boot.config.MqStatus;
import com.boot.pojo.DbMqDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 16:32
 * description:  CommitHandle
 * version:      V1.0
 * ******************************
 */
public class CommitHandle implements StatusInterface{

    // 已提交状态 | 重试状态
    @Override
    public void doAction(Context context) {
        DbMqDemo dbMqDemo = context.getDbMqDemo();
        Integer execnums = dbMqDemo.getExecnums();
        // 执行次数小于3  则执行
        if (execnums < 3) {

            // 设置为进行中
            dbMqDemo.setExecnums(execnums += 1);
            dbMqDemo.setDescription(MqStatus.DONEING.getDescr());
            dbMqDemo.setStatus(MqStatus.DONEING.getStatus());
            StatusInterface.getService().updateMQ(dbMqDemo);

            try {
                // 假装处理业务逻辑
                Thread.sleep(200);
                int num = (int) (Math.random() * 10);
                if (num < 3) {
                    throw new Exception("模拟异常");
                }

                // 进入成功逻辑
                context.setStatusInterface(new SuccessHandle());
            } catch (Exception e) {
                logger.error(e.getMessage(), new Throwable(e));

                // 异常则处理为异常状态 等待重试 | 且增加publishtime 向后延一下执行
                dbMqDemo.setDescription(MqStatus.ERROR_AGAIN.getDescr());
                dbMqDemo.setStatus(MqStatus.ERROR_AGAIN.getStatus());
                dbMqDemo.setPublishtime(dbMqDemo.getPublishtime() + 1000 * 20);
                StatusInterface.getService().updateMQ(dbMqDemo);

                // 设置为不继续执行
                context.setFlag(false);
            }
        } else {
            context.setStatusInterface(new ErrorHandle());
        }
    }

    private static Logger logger = LoggerFactory.getLogger(CommitHandle.class);
}
