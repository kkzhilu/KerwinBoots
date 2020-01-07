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
     * [刪除]
     **/
    int delete(int id);

    /**
     * [更新]
     **/
    int update(ScriptDir scriptdir);

    /**
     * [查询] 根据主键 id 查询
     **/
    ScriptDir load(int id);

    /**
     * [查询] 分页查询
     **/
    List<ScriptDir> pageList(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * [查询] 分页查询 count
     **/
    int pageListCount(int offset,int pagesize);
}
