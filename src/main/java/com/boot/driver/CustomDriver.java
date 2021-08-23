package com.boot.driver;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import com.mysql.jdbc.NonRegisteringDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * ******************************
 * author:       Kerwin
 * createTime:   2021/8/24 5:25
 * description:  CustomDriver
 * version:      V1.0
 * ******************************
 */
public class CustomDriver extends NonRegisteringDriver implements Driver {

    static {
        try {
            java.sql.DriverManager.registerDriver(new CustomDriver());
        } catch (SQLException ignored) {}
    }

    public CustomDriver() throws SQLException { }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        System.out.println("[Kerwin] 执行数据库连接...");
        return super.connect(url, info);
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
