package com.boot.bean;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 16:50
 * description:  WeiBoInfo
 * version:      V1.0
 * ******************************
 */
public class WeiBoInfo extends BaseBean {

    // WeiBo私有 排名
    private String order;

    public WeiBoInfo() { }

    public WeiBoInfo(String url, String desc, String order) {
        this.url   = url;
        this.desc  = desc;
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "WeiBoInfo{" +
                "order='" + order + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                "} " + super.toString();
    }
}
