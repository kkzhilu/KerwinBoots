package com.boot.web;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/24 10:50
 * description:  MQController
 * version:      V1.0
 * ******************************
 */
@RestController
public class MQController {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @RequestMapping("/sendMessage")
    public SendResult sendMessage (String message) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message sendMsg = new Message("DemoTopic","tagOne", message.getBytes());
        return defaultMQProducer.send(sendMsg);
    }
}
