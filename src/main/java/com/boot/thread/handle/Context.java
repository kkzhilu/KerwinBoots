package com.boot.thread.handle;

import com.boot.pojo.DbMqDemo;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 16:34
 * description:  Context 执行单元
 * version:      V1.0
 * ******************************
 */
public class Context {

    // 是否继续执行
    private Boolean flag;

    // DbMqDemo
    private DbMqDemo dbMqDemo;

    // StatusInterface
    private StatusInterface statusInterface;

    /***
     * 处理方法
     */
    public void handle () {
        statusInterface.doAction(this);
    }

    // ***************************************************************

    public DbMqDemo getDbMqDemo() {
        return dbMqDemo;
    }

    public void setDbMqDemo(DbMqDemo dbMqDemo) {
        this.dbMqDemo = dbMqDemo;
    }

    public StatusInterface getStatusInterface() {
        return statusInterface;
    }

    public void setStatusInterface(StatusInterface statusInterface) {
        this.statusInterface = statusInterface;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
