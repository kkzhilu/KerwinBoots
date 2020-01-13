package com.boot.dao;

import com.boot.bean.ScriptDir;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/12/30 10:27
 * description:  ScriptDirDao
 * version:      V1.0
 * ******************************
 */
@Mapper
public interface ScriptDirDao {

    /**
     * [新增]
     **/
    int insert(ScriptDir scriptdir);

    /**
     * [批量新增]
     **/
    int batchInsert(List<ScriptDir> list);

    /**
     * [更新]
     **/
    int update(ScriptDir scriptdir);

    /**
     * [删除]
     **/
    int delete(Object key);

    /**
     * [批量删除]
     **/
    int batchDelete(List<Object> list);

    /**
     * [主键查询]
     **/
    ScriptDir selectByKey(Object key);

    /**
     * [条件查询]
     **/
    List<ScriptDir> selectList (ScriptDir scriptDir);

    /**
     * [分页条件查询]
     **/
    List<ScriptDir> selectPage (@Param("scriptDir") ScriptDir scriptDir, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    /**
     * [总量查询]
     **/
    int total(ScriptDir scriptDir);
}
