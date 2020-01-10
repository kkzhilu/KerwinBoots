package com.boot.service;

import com.boot.bean.ScriptDir;
import com.boot.common.PageList;

import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/1/10 14:38
 * description:  ScriptDirService
 * version:      V1.0
 * ******************************
 */
public interface ScriptDirService {

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
    int batchDelete(List<Object> keys);

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
    PageList<ScriptDir> selectPage (ScriptDir scriptDir, Integer page, Integer pageSize);

    /**
     * [总量查询]
     **/
    int total(ScriptDir scriptDir);
}
