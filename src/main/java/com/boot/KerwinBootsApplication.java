package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class KerwinBootsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KerwinBootsApplication.class, args);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
