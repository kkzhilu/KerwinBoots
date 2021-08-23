package com.boot;

import com.boot.dao.ScriptDirDao;
import com.boot.spi.SPIInterface;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ServiceLoader;

/**
 * ******************************
 * author:       Kerwin
 * createTime:   2021/8/24 2:36
 * description:  SpiTest
 * version:      V1.0
 * ******************************
 */
public class SpiTest extends ApplicationTests {

    @Resource
    ScriptDirDao dirDao;

    @Test
    public void testSpi() {
        ServiceLoader<SPIInterface> load = ServiceLoader.load(SPIInterface.class);
        for (SPIInterface ser : load) {
            System.out.println(ser.handle());
        }

        dirDao.show();
    }

    @Test
    public void customDriver() {
        try {
            dirDao.customDriver();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
