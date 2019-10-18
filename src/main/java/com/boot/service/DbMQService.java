package com.boot.service;

import com.boot.dao.DbMQMapper;
import com.boot.pojo.DbMqDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 15:42
 * description:  DbMQMapper
 * version:      V1.0
 * ******************************
 */
@Service
public class DbMQService {

    @Resource
    DbMQMapper mapper;

    /***
     * 更新 - 此Demo 数据源头是单线程, 队列不会重复放消息
     * 所以不存在消费线程消费同一条记录的情况，因此不用加锁，真实场景需仔细考虑是否需要加锁
     */
    public Integer updateMQ(DbMqDemo dbMqDemo) {
        Integer result = 0;
        try {
            result = mapper.updateMQ(dbMqDemo);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), new Throwable(ex));
        }
        return result;
    }

    /***
     * 插入 - 根据业务定是否加锁
     */
    public Integer insertMQ(DbMqDemo dbMqDemo) {
        return mapper.insertMQ(dbMqDemo);
    }

    /***
     * 查找数据
     */
    public List<DbMqDemo> selectMQ(int status) {
        List<DbMqDemo> result = mapper.selectMQ(status, System.currentTimeMillis());
        return result != null ? result : new ArrayList<>();
    }

    private static Logger logger = LoggerFactory.getLogger(DbMQService.class);
}
