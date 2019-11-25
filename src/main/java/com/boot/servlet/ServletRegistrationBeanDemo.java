package com.boot.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/11/25 11:51
 * description:  ServletRegistrationBeanDemo
 * version:      V1.0
 * ******************************
 */
public class ServletRegistrationBeanDemo extends HttpServlet {

    /***
     *     public ServletRegistrationBean<ServletRegistrationBeanDemo> servletBean() {
     *         ServletRegistrationBean<ServletRegistrationBeanDemo> registrationBean = new ServletRegistrationBean<>();
     *         registrationBean.addUrlMappings("/bean");
     *         registrationBean.setServlet(new ServletRegistrationBeanDemo());
     *         return registrationBean;
     *     }
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("This is ServletRegistrationBean Demo.");
    }
}
