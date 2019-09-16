package com.boot.service;

import com.boot.dao.StudentMapper;
import com.boot.pojo.Student;
import com.boot.source.DS;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 11:23
 * description:  StudentServiceImpl
 * version:      V1.0
 * ******************************
 */
@Service
public class StudentServiceImpl {

    @Resource
    StudentMapper studentMapper;

    public boolean insert (String name) {
        return studentMapper.insert(name) > 0;
    }

    /** 测试事务注解 **/
    @Transactional
    public boolean insertTestTrans (String name) throws Exception {
        System.out.println(studentMapper.list());
        System.out.println(studentMapper.insert(name) > 0);
        System.out.println(studentMapper.list());
        System.out.println(5 / 0);
        return true;
    }

    // 走方法名 自动切换数据源
    public List<Student> list () {
        return studentMapper.list();
    }

//    @DS("selectDataSource")
//    public List<Student> anSelectList () {
//       return studentMapper.list();
//    }
//
//    @DS("updateDataSource")
//    public List<Student> anUpdateList () {
//        return studentMapper.list();
//    }
}
