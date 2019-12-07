package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.bean.CodeFile;
import com.boot.mapper.CodeFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/12/7 10:51
 * description:  CodeFileImpl
 * version:      V1.0
 * ******************************
 */
@Service
public class CodeFileImpl {

    @Resource
    CodeFileMapper codeFileMapper;

    public int getCount () {
        return codeFileMapper.selectCount(null);
    }

    public List<CodeFile> select () {
        return codeFileMapper.selectList(null);
    }

    public List<CodeFile> selectPage (int page, int pageSize) {
        IPage<CodeFile> userPage = new Page<>(page, pageSize);
        userPage = codeFileMapper.selectPage(userPage, null);
        return userPage.getRecords();
    }
}
