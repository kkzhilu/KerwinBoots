package com.boot.dao;

import com.boot.pojo.CodeFile;
import com.boot.pojo.RootFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/30 15:24
 * description:  CodeFileDao
 * version:      V1.0
 * ******************************
 */
@Mapper
@Repository
public interface CodeFileDao {

    @Insert("insert into code_file values (#{cf.uuid}, #{cf.fileName}, #{cf.fileType}, #{cf.path}, #{cf.content})")
    int insert(@Param("cf") CodeFile codeFile);

    @Select(" select * from  code_file where uuid = #{uuid}")
    CodeFile get (String uuid);
}
