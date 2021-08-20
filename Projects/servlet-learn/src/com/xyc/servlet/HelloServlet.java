package com.xyc.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName HelloServlet
 * @Description TODO
 * @Author xuyichao-xuyichao
 * @Date 2021/8/8 15:17
 * @Version 1.0
 **/
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet 被访问了！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
