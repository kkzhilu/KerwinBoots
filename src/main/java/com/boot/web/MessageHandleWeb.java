package com.boot.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/12 16:07
 * description:  MessageHandle 消息处理
 * version:      V1.0
 * ******************************
 */
@RestController
public class MessageHandleWeb {

    @PostMapping("/wechat")
    public String messageHandle (HttpServletRequest request) {
        return null;
    }
}
