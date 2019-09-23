package com.boot.web;


import com.boot.meJedis.CommandUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/20 10:47
 * description:  Redis MyJedis Test
 * version:      V1.0
 * ******************************
 */
@RestController
public class JedisDemo {

    @RequestMapping("/set")
    public String testJedis (String key, String value) {
        try {
            CommandUtil.set(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Please see console.";
    }

    @RequestMapping("/get")
    public String testJedisGet (String key) {
        try {
            CommandUtil.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Please see console.";
    }
}
