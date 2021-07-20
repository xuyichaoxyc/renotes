package com.xyc.learn.test.proxytest.aoptest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyInvocationHandler
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/20 16:31
 * @Version 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {

    // 需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke 方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil du = new DogUtil();

        du.method1();

        Object result = method.invoke(target, args);

        du.method2();

        return result;
    }
}
