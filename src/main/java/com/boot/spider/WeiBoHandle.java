package com.boot.spider;

import com.boot.bean.WeiBoInfo;
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

    private static List<WeiBoInfo> getWeiBoInfos () {
        List<WeiBoInfo> weiBoInfos = new ArrayList<>();
        AbstractHandle.getBeans(WeiBoInfo.URL, WeiBoInfo.CSS, weiBoInfos,
                (Element element) -> {
                    WeiBoInfo weiBoInfo = WeiBoInfo.parseElement(element);
                    if (weiBoInfo != null) {
                        weiBoInfos.add(weiBoInfo);
                    }
                });
        return weiBoInfos;
    }
}
