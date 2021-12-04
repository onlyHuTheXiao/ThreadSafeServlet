/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.example.demotest.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * todo 写下 你的注释
 *
 * @author huwy
 * @version 1.0.0
 * @createdAt 2021/12/4 13:39
 * @updatedAt 2021/12/4 13:39
 */
public class ThreadSafeServlet extends HttpServlet {

    //静态变量，可能发生线程安全问题
    public static String name = "Hello";
    //实例变量，可能发生线程安全问题
    int i;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servelt 初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("%s:%s[%s]\n",Thread.currentThread().getName(),i,format.format(new Date()));

        i++;

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
        System.out.printf("%s:%s[%s]\n",Thread.currentThread().getName(),i,format.format(new Date()));

        resp.getWriter().println("<html><body><h1>\" + i + \"</h1></body></html");
    }
}
