package com.boot.web;

import com.boot.annotation.RateLimiterAnno;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * ******************************
 * author:       Kerwin
 * createTime:   2021/6/20 0:59
 * description:  TODO
 * version:      V1.0
 * ******************************
 */
@Controller
@RequestMapping
public class Demo {

    @RequestMapping("/test3")
    @ResponseBody
    public Map<String, String> test3(HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        return map;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public Map<String, String> test4(HttpServletResponse response) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", String.format(
                "attachment; filename=%s_%s.xls", "Demo", System.currentTimeMillis()));

        OutputStream out = response.getOutputStream();
        out.flush();
        out.close();
        return map;
    }
}
