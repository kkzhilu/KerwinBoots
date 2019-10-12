package com.boot.bean;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 16:48
 * description:  BaseBean
 * version:      V1.0
 * ******************************
 */
public abstract class BaseBean {

    // url信息
    protected String url;

    // desc描述信息
    protected String desc;

    public BaseBean () { }

    public BaseBean (String url, String desc) {
        this.url  = url;
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
