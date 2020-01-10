package com.boot.service.impl;

import com.boot.bean.ScriptDir;
import com.boot.common.PageList;
import com.boot.dao.ScriptDirDao;
import com.boot.service.ScriptDirService;
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
public class ScriptDirServiceImpl implements ScriptDirService {

    @Autowired
    ScriptDirDao scriptDao;

    @Override
    public int insert(ScriptDir scriptdir) {
        return scriptDao.insert(scriptdir);
    }

    @Override
    public int batchInsert(List<ScriptDir> list) {
        return scriptDao.batchInsert(list);
    }

    @Override
    public int update(ScriptDir scriptdir) {
        return scriptDao.update(scriptdir);
    }

    @Override
    public int delete(Object key) {
        return scriptDao.delete(key);
    }

    @Override
    public int batchDelete(List<Object> keys) {
        return scriptDao.batchDelete(keys);
    }

    @Override
    public ScriptDir selectByKey(Object key) {
        return scriptDao.selectByKey(key);
    }

    @Override
    public List<ScriptDir> selectList(ScriptDir scriptDir) {
        return scriptDao.selectList(scriptDir);
    }

    @Override
    public PageList<ScriptDir> selectPage(ScriptDir scriptDir, Integer offset, Integer pageSize) {
        PageList<ScriptDir> pageList = new PageList<>();

        int total = this.total(scriptDir);

        Integer totalPage;
        if (total % pageSize != 0) {
            totalPage = (total /pageSize) + 1;
        } else {
            totalPage = total /pageSize;
        }

        int page = (offset - 1) * pageSize;

        List<ScriptDir> list = scriptDao.selectPage(scriptDir, page, pageSize);

        pageList.setList(list);
        pageList.setStartPageNo(offset);
        pageList.setPageSize(pageSize);
        pageList.setTotalCount(total);
        pageList.setTotalPageCount(totalPage);
        return pageList;
    }

    @Override
    public int total(ScriptDir scriptDir) {
        return scriptDao.total(scriptDir);
    }
}
