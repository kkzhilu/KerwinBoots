package com.boot.event;

import com.boot.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * ******************************
 * author:       ext.kexianming
 * createTime:   2021/7/9 5:09 下午
 * description:  WebEventListener
 * version:      V1.0
 * ******************************
 */
@Component
public class WebEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebEventListener.class);

    /**
     * 仅监听字段值为 foo 时，类为 User.class 时
     */
    @EventListener(classes = User.class, condition = "#event.name == 'foo'")
    public void listen(User event){
        logger.error("Event: " + event);
    }

    /**
     * 监听 User.class 情况
     */
    @EventListener(classes = User.class)
    public void listen1(User event){
        logger.error("Event: " + event);
    }
}
