package com.boot.web;

import com.boot.config.MqStatus;
import com.boot.pojo.DbMqDemo;
import com.boot.service.DbMQService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 16:09
 * description:  InsertMQData
 * version:      V1.0
 * ******************************
 */
@RestController
public class InsertMQData {

    @Resource
    DbMQService dbMQService;

    @RequestMapping("/insert")
    public String insertMqData() {
        for (int i = 0; i < 5000; i++) {
            DbMqDemo dbMqDemo = new DbMqDemo();
            dbMqDemo.setUuid(UUID.randomUUID().toString());
            dbMqDemo.setDescription(MqStatus.HAVA_COMMIT.getDescr());
            dbMqDemo.setPublishtime(System.currentTimeMillis() + (long) (Math.random() * 10000));
            dbMqDemo.setStatus(MqStatus.HAVA_COMMIT.getStatus());
            dbMQService.insertMQ(dbMqDemo);
        }
        return "ok";
    }
}
