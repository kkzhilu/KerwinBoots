package com;

import com.alibaba.fastjson.JSON;
import com.boot.KerwinBootsApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/23 17:56
 * description:  App
 * version:      V1.0
 * ******************************
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KerwinBootsApplication.class})
public class App {

    private byte[] getMsgBytes(Object o) {
        try {
            if (o == null) {
                return null;
            }
            if (String.class == o.getClass()) {
                return ((String) o).getBytes("UTF-8");
            } else {
                return JSON.toJSONBytes(o);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
