package com.boot.handle;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/11/22 16:55
 * description:  ApiDataUtil
 * version:      V1.0
 * ******************************
 */
public class ApiDataUtil {

    /** 所有类的Class地址 **/
    private static List<String> classNames = new ArrayList<>();

    /** Bean容器 **/
    private static Map<String, Object> iocFactory = new HashMap<>();

    /** HandlerMapping - 方法**/
    private static Map<String, Method> handleMapping = new HashMap<>();

    public static List<String> getClassNames() {
        return classNames;
    }

    public static Map<String, Object> getIocFactory() {
        return iocFactory;
    }

    public static Map<String, Method> getHandleMapping() {
        return handleMapping;
    }
}
