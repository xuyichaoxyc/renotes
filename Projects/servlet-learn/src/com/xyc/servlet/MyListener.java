package com.xyc.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName MyListener
 * @Description TODO
 * @Author xuyichao-xuyichao
 * @Date 2021/8/8 16:48
 * @Version 1.0
 **/
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener.contextInitialized方法被调用");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener.contextDestroyed方法被调用");
    }
}
