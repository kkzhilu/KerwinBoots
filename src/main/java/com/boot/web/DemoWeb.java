package com.boot.web;

import com.boot.bean.ConfigStaticBean;
import com.boot.bean.ConfigStaticNewBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/5/19 10:50
 * description:  DemoWeb
 * version:      V1.0
 * ******************************
 */
@Controller
public class DemoWeb {

    @RequestMapping("/demo")
    @ResponseBody
    public String demo () {
        return ConfigStaticBean.getValue("demo");
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public String demo2 () {
        return ConfigStaticNewBean.getValue("demo");
    }
}
