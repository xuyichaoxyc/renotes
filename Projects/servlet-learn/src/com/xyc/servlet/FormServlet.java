package com.xyc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName FormServlet
 * @Description TODO
 * @Author xuyichao-xuyichao
 * @Date 2021/8/8 16:11
 * @Version 1.0
 **/
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的编码格式为UTF-8编码，否则产生中文乱码现象
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getMethod();

        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String webName = request.getContextPath();
        String querryString = request.getQueryString();

        response.getWriter().write("<h1>下面是获得的字符串</h1>");
        response.getWriter().write("<h1>method(HTTP方法):<h1>");
        response.getWriter().write("<h1>"+method+"</h1><br>");
        response.getWriter().write("<h1>requestURi(请求URI）:</h1>");
        response.getWriter().write("<h1>" + requestURI + "</h1><br>");
        response.getWriter().write("<h1>webname(应用名称):</h1>");
        response.getWriter().write("<h1>" + webName + "</h1><br>");
        response.getWriter().write("<h1>querrystring(查询字符串):</h1>");
        response.getWriter().write("<h1>" + querryString + "</h1>");

    }
}
