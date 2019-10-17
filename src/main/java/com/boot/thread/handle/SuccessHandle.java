package com.boot.thread.handle;

import com.boot.config.MqStatus;
import com.boot.pojo.DbMqDemo;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 16:32
 * description:  DoHandle
 * version:      V1.0
 * ******************************
 */
public class SuccessHandle implements StatusInterface{

    @Override
    public void doAction(Context context) {
        // 执行成功
        DbMqDemo dbMqDemo = context.getDbMqDemo();
        dbMqDemo.setDescription(MqStatus.DONE.getDescr());
        dbMqDemo.setStatus(MqStatus.DONEING.getStatus());
        StatusInterface.getService().updateMQ(dbMqDemo);

        // 不用执行了
        context.setFlag(false);
    }
}
