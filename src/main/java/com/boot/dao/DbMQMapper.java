package com.boot.dao;

import com.boot.pojo.DbMqDemo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/10/17 15:42
 * description:  DbMQMapper
 * version:      V1.0
 * ******************************
 */
@Mapper
public interface DbMQMapper {

    @Insert(" insert into db_mq_demo values (#{demo.uuid}, 0, #{demo.description}, #{demo.publishtime}, #{demo.status})")
    Integer insertMQ (@Param("demo") DbMqDemo dbMqDemo);

    @Update({" update db_mq_demo set " +
            "execnums = #{demo.execnums}, " +
            "description = #{demo.description}, " +
            "publishtime = #{demo.publishtime}, " +
            "status = #{demo.status} " +
            "where uuid = #{demo.uuid}"})
    Integer updateMQ (@Param("demo") DbMqDemo dbMqDemo);

    @Select({" select * from db_mq_demo where status = #{status} and publishtime < #{curr} order by publishtime limit 0, 1000"})
    List<DbMqDemo> selectMQ (@Param("status") int status, @Param("curr") long currTime);
}
