package com.xyc.learn.test.base.proxytest.AopTest;

import java.lang.reflect.Proxy;

/**
 * @ClassName MyProxyFactory
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/20 16:37
 * @Version 1.0
 **/
public class MyProxyFactory {
    public static Object getProxy(Object target) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
