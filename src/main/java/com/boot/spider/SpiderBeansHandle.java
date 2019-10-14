package com.boot.spider;

import com.boot.utils.SpiderUtils;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/14 8:58
 * description:  Spider Handle Interface
 * version:      V1.0
 * ******************************
 */
public interface SpiderBeansHandle<T> {

    /**
     * 获取Url
     */
    String getUrl();

    /**
     * 获取Cookie
     */
    String getCookie();

    /***
     * 获取CSS selector
     */
    String getSelector();

    /***
     * 解析Element
     * @param element  element
     */
    T parseElement(Element element);

    /***
     * Get Beans
     * @param handle  Bean对象 | handle对象
     * @param <T>     Bean类型
     * @return        List<Beans>
     */
    static <T> List<T> getBeans(SpiderBeansHandle<T> handle) {
        List<T> list = new ArrayList<>();
        List<Element> elements = SpiderUtils.getElementWithCookie(handle.getUrl(), handle.getSelector(), handle.getCookie());
        for (Element element : elements) {
            T bean = handle.parseElement(element);
            if (bean != null) {
                list.add(bean);
            }
        }
        return list;
    }
}
