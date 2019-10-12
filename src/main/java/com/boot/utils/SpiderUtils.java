package com.boot.utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/9 17:13
 * description:  Java 爬虫 SpiderUtils
 * version:      V1.0
 * ******************************
 */
public class SpiderUtils {

    /***
     * @param url     url
     * @param cookie  cookie
     * @return        Document
     */
    private static Document getDocument (String url, String cookie) {
        try {
            Document document;
            if (StringUtils.isNotBlank(cookie)) {
                document = Jsoup.connect(url) .header("Cookie", cookie).get();
            } else {
                document = Jsoup.connect(url).get();
            }

            return document;
        } catch (IOException e) {
            logger.error(e.getMessage() , new Throwable(e));
        }

        return null;
    }

    public static String getJsonStringWithNoCookie (String targetUrl) {
        return getJsonStringWithCookie(targetUrl, null);
    }

    public static String getJsonStringWithCookie (String targetUrl, String cookie) {
        Document document = getDocument(targetUrl, cookie);
        assert document != null;
        return document.body().text();
    }

    public static List<Element> getElementWithNoCookie (String targetUrl, String desc) {
        return getElementWithCookie(targetUrl, desc, null);
    }

    /***
     * 获取元素 | 无验证条件
     * @param targetUrl  目标网址
     * @param desc       CSS描述   div.news-list > ul > li > div.list-hd > h4 > a
     * @param cookie     cookie    authtoken_pro=tecf8e3bda2533f47e52916d610516f7...
     * @return           Elements  element.attr("href"),element.ownText()
     */
    public static List<Element> getElementWithCookie (String targetUrl, String desc, String cookie) {
        Document document = getDocument(targetUrl, cookie);
        assert document != null;
        return document.select(desc);
    }


    /***
     * 构造登陆参数
     *    Map<String,String> data = new HashMap<>();
     *    data.put("name","your_account");
     *    data.put("password","your_password");
     *    data.put("remember","false");
     *    data.put("ticket","");
     *    data.put("ck","");
     *
     * @use Jsoup.connect(userInfoUrl).cookies(login.cookies())
     */
    public static Connection.Response login (String loginUrl, Map<String, String> paramsMap) throws IOException {
        Connection.Response login = Jsoup.connect(loginUrl)
                .ignoreContentType(true)  // 忽略类型验证
                .followRedirects(false)   // 禁止重定向
                .postDataCharset("utf-8")
                .header("Upgrade-Insecure-Requests","1")
                .header("Accept","application/json")
                .header("Content-Type","application/x-www-form-urlencoded")
                .header("X-Requested-With","XMLHttpRequest")
                .header("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
                .data(paramsMap)
                .method(Connection.Method.POST)
                .execute();
        login.charset("UTF-8");
        return login;
    }

    /***
     * 获取指定网页内容
     * @param url          url
     * @return             string
     * @throws IOException IOException
     */
    public static String getHtmlText (String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.body().text();
    }

    /***
     * 获取指定网页内容
     * @param url          url
     * @return             string
     * @throws IOException IOException
     */
    public static String getHtmlContentByIo (String url) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        URL turl = null;
        BufferedReader br = null;
        try {
            turl = new URL(url);
            br = new BufferedReader(new InputStreamReader(turl.openStream(), StandardCharsets.UTF_8));
            String s;
            while((s = br.readLine()) != null) {
                stringBuilder.append(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static Logger logger = LoggerFactory.getLogger(SpiderUtils.class);
}
