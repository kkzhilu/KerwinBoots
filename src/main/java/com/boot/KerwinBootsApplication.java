package com.boot;

import com.boot.handle.ApiServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KerwinBootsApplication {

    @Bean
    public ServletRegistrationBean<ApiServlet> registerServlet() {
        return new ServletRegistrationBean<>(new ApiServlet(), "/*");
    }

    public static void main(String[] args) {
        SpringApplication.run(KerwinBootsApplication.class, args);
    }
}
