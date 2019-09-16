package com.boot.dao;

import com.boot.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 11:14
 * description:  StudentMapper
 * version:      V1.0
 * ******************************
 */
@Mapper
public interface StudentMapper {

    @Insert(" insert into student values (null, #{name}) ")
    int insert(String name);

    @Select(" select * from student ")
    List<Student> list();
}
