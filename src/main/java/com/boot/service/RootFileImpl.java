package com.boot.service;

import com.boot.dao.RootFileDao;
import com.boot.pojo.RootFile;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/30 15:37
 * description:  RootFileImpl
 * version:      V1.0
 * ******************************
 */
@Service
public class RootFileImpl {

    @Resource
    RootFileDao rootFileDao;

    public boolean insert (RootFile rootFile) {
        return rootFileDao.insert(rootFile) > 0;
    }

    public RootFile get (String uuid) {
        return rootFileDao.get(uuid);
    }

    public List<RootFile> getRootFiles () {
        return rootFileDao.getRootFiles();
    }

    public Map<String, RootFile> getFilesByMap () {
        Map<String, RootFile> result = new HashMap<>();
        List<RootFile> fileList = rootFileDao.getRootFiles();
        for (RootFile rootFile : fileList) {
            if (!result.containsKey(rootFile.getFileName())) {
                result.put(rootFile.getFileName(), rootFile);
            }
        }
        return result;
    }
}
