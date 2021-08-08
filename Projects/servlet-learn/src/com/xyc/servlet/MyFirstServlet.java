package com.xyc.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName MyFirstServlet
 * @Description TODO
 * @Author xuyichao-xuyichao
 * @Date 2021/8/8 15:24
 * @Version 1.0
 **/
public class MyFirstServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet 正在初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 专门向客户端提供相应的方法
        System.out.println("Servlet 正在提供服务");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet 正在销毁");
    }
}
