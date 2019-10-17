package com.boot.thread.handle;

import com.boot.config.MqStatus;
import com.boot.config.SpringContextUtil;
import com.boot.service.DbMQService;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/7/26 12:48
 * description:  状态模式接口
 * version:      V1.0
 * ******************************
 */
public interface StatusInterface {

    // 不同状态下任务处理
    void doAction(Context context);

    // 获取service bean
    static DbMQService getService () {
        return (DbMQService) SpringContextUtil.getBean("dbMQService");
    }
}
