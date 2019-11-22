package com.boot.api;

import com.alibaba.fastjson.JSONObject;
import com.boot.annotation.Api;

import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/11/22 15:56
 * description:  ApiDemo
 * version:      V1.0
 * ******************************
 */
@Api
public class ApiDemo {

    public String testString (JSONObject object) {
        return object.toJSONString();
    }

    public List<String> testList (JSONObject object) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(object);
        return list;
    }
}
