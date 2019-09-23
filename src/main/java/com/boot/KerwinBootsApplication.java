package com.boot;

import com.boot.meJedis.JedisApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class KerwinBootsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KerwinBootsApplication.class, args);

        // 建立Socket连接
        try {
            JedisApp.connect("127.0.0.1", 6379);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
