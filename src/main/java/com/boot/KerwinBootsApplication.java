package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boot.mapper")
public class KerwinBootsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KerwinBootsApplication.class, args);
    }
}
