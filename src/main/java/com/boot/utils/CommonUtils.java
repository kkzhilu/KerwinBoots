package com.boot.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/17 11:19
 * description:  Kerwin 公共工具类 | 尽量只依赖日志库
 * version:      V1.0
 * ******************************
 */
public class CommonUtils {

    /***
     * 获取时间  2019年9月17日 下午02时58分33秒
     * @return                         String
     */
    public static String getChineseDate() {
        return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CHINESE).format(new Date());
    }
}
