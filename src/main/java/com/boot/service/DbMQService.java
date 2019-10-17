package com.boot.service;

import com.boot.dao.DbMQMapper;
import com.boot.pojo.DbMqDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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

    // 锁
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    @Resource
    DbMQMapper mapper;

    /***
     * 更新 - 必须加锁 | 此处无所谓力度直接加
     * 实际情况可以考虑把颗粒度弄低一点, 性能可以提示
     */
    public Integer updateMQ(DbMqDemo dbMqDemo) {
        lock.writeLock().lock();
        Integer result = 0;
        try {
            result = mapper.updateMQ(dbMqDemo);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), new Throwable(ex));
        } finally {
            // 必须解锁
            lock.writeLock().unlock();
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
