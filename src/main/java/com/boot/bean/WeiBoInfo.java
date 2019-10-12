package com.boot.bean;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 16:50
 * description:  WeiBoInfo
 * version:      V1.0
 * ******************************
 */
public class WeiBoInfo extends BaseBean {

    private  static final String ROOT = "https://s.weibo.com";

    public   static final String URL = "https://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6";

    public   static final String CSS = "div.data > table > tbody > tr";

    /***
     * PoJo 根据业务解析
     */
    public static WeiBoInfo parseElement (Element element) {
        String order = element.child(0).ownText();
        if (StringUtils.isBlank(order)) {
            return null;
        }

        String url = ROOT + element.child(1).child(0).attr("href");
        String desc = element.child(1).child(0).ownText();
        return new WeiBoInfo(url, desc, order);
    }

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
