package com.boot.bean;

import com.boot.spider.SpiderBeansHandle;
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
public class WeiBoInfo implements SpiderBeansHandle<WeiBoInfo> {

    private  static final String ROOT = "https://s.weibo.com";

    @Override
    public String getUrl() {
        return "https://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6";
    }

    @Override
    public String getCookie() {
        return null;
    }

    @Override
    public String getSelector() {
        return "div.data > table > tbody > tr";
    }

    @Override
    public WeiBoInfo parseElement(Element element) {
        String order = element.child(0).ownText();
        if (StringUtils.isBlank(order)) {
            return null;
        }

        String url = ROOT + element.child(1).child(0).attr("href");
        String desc = element.child(1).child(0).ownText();
        return new WeiBoInfo(order, url, desc);
    }


    // WeiBo私有 排名
    private String topicOrder;

    private String topicUrl;

    private String topicText;

    public String getTopicOrder() {
        return topicOrder;
    }

    public void setTopicOrder(String topicOrder) {
        this.topicOrder = topicOrder;
    }

    public String getTopicUrl() {
        return topicUrl;
    }

    public void setTopicUrl(String topicUrl) {
        this.topicUrl = topicUrl;
    }

    public String getTopicText() {
        return topicText;
    }

    public void setTopicText(String topicText) {
        this.topicText = topicText;
    }

    @Override
    public String toString() {
        return "WeiBoInfo{" +
                "topicOrder='" + topicOrder + '\'' +
                ", topicUrl='" + topicUrl + '\'' +
                ", topicText='" + topicText + '\'' +
                '}';
    }

    public WeiBoInfo(String topicOrder, String topicUrl, String topicText) {
        this.topicOrder = topicOrder;
        this.topicUrl = topicUrl;
        this.topicText = topicText;
    }

    public WeiBoInfo() { }
}
