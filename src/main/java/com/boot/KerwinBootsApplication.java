package com.boot;

import com.boot.servlet.ServletRegistrationBeanDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/***
 * SpringBoot 注册Servlet的常用方式
 * https://juejin.im/post/5ddb217df265da7e117dc01e?utm_source=gold_browser_extension#heading-4
 */
@SpringBootApplication
@ServletComponentScan
public class KerwinBootsApplication {

    @Bean
    public ServletRegistrationBean<ServletRegistrationBeanDemo> servletBean() {
        ServletRegistrationBean<ServletRegistrationBeanDemo> registrationBean = new ServletRegistrationBean<>();
        registrationBean.addUrlMappings("/bean");
        registrationBean.setServlet(new ServletRegistrationBeanDemo());
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(KerwinBootsApplication.class, args);
    }
}
