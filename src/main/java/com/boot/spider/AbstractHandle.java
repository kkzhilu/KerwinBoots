package com.boot.spider;

import com.boot.utils.SpiderUtils;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.function.Consumer;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 17:35
 * description:  AbstractHandle
 * version:      V1.0
 * ******************************
 */
public abstract class AbstractHandle {

    /***
     * Get Beans
     */
    public static void getBeans (String rootUrl, String css, List<?> result, Consumer<Element> handle) {
        List<Element> elements = SpiderUtils.getElementWithNoCookie(rootUrl, css);
        for (Element element : elements) {
            handle.accept(element);
        }
    }
}
