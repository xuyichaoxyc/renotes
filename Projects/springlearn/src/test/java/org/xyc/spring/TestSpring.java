package org.xyc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 8:55
 */
public class TestSpring {
    @Test
    public void testCon() {
        // 初始化 Spring 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 提取Bean
        Hello hello = (Hello) ctx.getBean("hello");
        hello.say();
    }
}
