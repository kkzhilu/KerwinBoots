package com.boot.service.impl;

import com.boot.service.CustomStrategyInterface;
import org.springframework.stereotype.Component;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/4/15 9:34
 * description:  BiLiBiLiImpl
 * version:      V1.0
 * ******************************
 */
@Component
public class BiLiBiLiImpl implements CustomStrategyInterface {
    @Override
    public void handle() {
        System.out.println("这里是哔哩哔哩");
    }
}
