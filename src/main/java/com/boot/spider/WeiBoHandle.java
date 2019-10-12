package com.boot.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.boot.bean.WeiBoInfo;
import com.boot.utils.SpiderUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 17:01
 * description:  WeiBoHandle
 * version:      V1.0
 * ******************************
 */
public class WeiBoHandle {

    private static final String ROOT_URL = "https://s.weibo.com";

    private static List<WeiBoInfo> getWeiBoInfos () {

        // WeiBoInfo
        List<WeiBoInfo> result = new ArrayList<>();

        String rootUrl  = "https://s.weibo.com/top/summary?Refer=top_hot&topnav=1&wvr=6";
        String css      = "div.data > table > tbody > tr";
        List<Element> elements = SpiderUtils.getElementWithNoCookie(rootUrl, css);
        for (Element element : elements) {

            String order = element.child(0).ownText();
            if (StringUtils.isBlank(order)) {
                continue;
            }

            String url   = ROOT_URL + element.child(1).child(0).attr("href");
            String desc  = element.child(1).child(0).ownText();

            WeiBoInfo weiBoInfo = new WeiBoInfo(url, desc, order);
            result.add(weiBoInfo);
        }

        return result;
    }
}
