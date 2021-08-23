package com.boot.spi.impl;

import com.boot.spi.SPIInterface;

import java.time.LocalDateTime;

/**
 * ******************************
 * author:       Kerwin
 * createTime:   2021/8/24 2:33
 * description:  SPIInterfaceImpl
 * version:      V1.0
 * ******************************
 */
public class SPIInterfaceImpl implements SPIInterface {
    @Override
    public String handle() {
        return "当前时间为: " + LocalDateTime.now();
    }
}
