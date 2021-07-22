package com.xyc.learn.test.proxytest.aoptest;

/**
 * @ClassName DogUtil
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/20 16:30
 * @Version 1.0
 **/
public class DogUtil {
    // 第一个拦截器方法
    public void method1() {
        System.out.println("====== 模拟第一个通用方法 ======");
    }

    // 第二个拦截器方法
    public void method2() {
        System.out.println("====== 模拟第二个通用方法 ======");
    }
}
