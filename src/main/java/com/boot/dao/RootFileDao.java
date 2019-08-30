package com.boot.dao;

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
 * description:  RootFileDao
 * version:      V1.0
 * ******************************
 */
@Mapper
@Repository
public interface RootFileDao {

    @Insert("insert into root_file values (#{rf.uuid}, #{rf.fileName}, #{rf.desc},  #{rf.content})")
    int insert (@Param("rf") RootFile rootFile);

    @Select(" select * from  root_file where uuid = #{uuid}")
    RootFile get (String uuid);

    @Select(" select * from  root_file")
    List<RootFile> getRootFiles ();
}
