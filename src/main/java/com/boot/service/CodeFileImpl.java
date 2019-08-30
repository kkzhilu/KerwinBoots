package com.boot.service;

import com.boot.dao.CodeFileDao;
import com.boot.pojo.CodeFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/30 15:36
 * description:  CodeFileImpl
 * version:      V1.0
 * ******************************
 */
@Service
public class CodeFileImpl {

    @Resource
    CodeFileDao codeFileDao;

    public boolean insert(CodeFile codeFile) {
        return codeFileDao.insert(codeFile) > 0;
    }

    public CodeFile get (String uuid) {
        return codeFileDao.get(uuid);
    }
}
