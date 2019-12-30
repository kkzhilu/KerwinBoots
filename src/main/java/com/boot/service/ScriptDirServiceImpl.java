package com.boot.service;

import com.boot.bean.ScriptDir;
import com.boot.dao.ScriptDirDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/12/30 10:38
 * description:  ScriptDirServiceImpl
 * version:      V1.0
 * ******************************
 */
@Service
public class ScriptDirServiceImpl {

    @Autowired
    ScriptDirDao scriptDao;

    /**
     * [新增]
     **/
    public int insert(ScriptDir scriptdir) {
        return scriptDao.insert(scriptdir);
    }

    /**
     * [刪除]
     **/
    public int delete(int id) {
        return scriptDao.delete(id);
    }

    /**
     * [更新]
     **/
    public int update(ScriptDir scriptdir) {
        return scriptDao.update(scriptdir);
    }

    /**
     * [查询] 根据主键 id 查询
     **/
    public ScriptDir load(int id) {
        return scriptDao.load(id);
    }

    /**
     * [查询] 分页查询
     **/
    public List<ScriptDir> pageList(int offset, int pagesize) {
        return scriptDao.pageList((offset - 1) * pagesize, pagesize);
    }

    /**
     * [查询] 分页查询 count
     **/
    public int pageListCount(int offset,int pagesize) {
        return scriptDao.pageListCount((offset - 1) * pagesize, pagesize);
    }
}
