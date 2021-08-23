package com.boot.dao;

import com.boot.bean.ScriptDir;
import com.boot.mapper.ScriptDirMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.*;
import java.util.List;

/**
 * ******************************
 * author:       Kerwin
 * createTime:   2021/8/24 5:19
 * description:  ScriptDirDao
 * version:      V1.0
 * ******************************
 */
@Service
public class ScriptDirDao {

    @Resource
    ScriptDirMapper scriptDirMapper;

    public void show() {
        List<ScriptDir> dirs = scriptDirMapper.selectList(null);
        System.out.println("Size: " + dirs.size());
    }

    public void customDriver() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_file?characterEncoding=UTF-8&useSSL=false", "root", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM script_dir LIMIT 1");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}
