package com.boot.web;

import com.boot.web.model.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRequest implements ApplicationContextAware {

    private ApplicationContext appContext;


    @RequestMapping("/testEvent")
    public String testEventSave(String name) {
        appContext.publishEvent(new User(this, name));
        return "ok";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
