package com.boot;

import com.boot.spi.SPIInterface;
import org.junit.Test;

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

    @Test
    public void testSpi() {
        ServiceLoader<SPIInterface> load = ServiceLoader.load(SPIInterface.class);
        for (SPIInterface ser : load) {
            System.out.println(ser.handle());
        }
    }
}
