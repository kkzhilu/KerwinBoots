package com.boot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/11/25 10:43
 * description:  @WebServlet           注解Demo
 *               @ServletComponentScan 注解配合
 * version:      V1.0
 * ******************************
 */
@WebServlet(value = "/webServlet")
public class WebServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("This is WebServlet.");
    }
}
