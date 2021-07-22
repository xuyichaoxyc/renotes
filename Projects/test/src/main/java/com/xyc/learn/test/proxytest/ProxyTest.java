package com.xyc.learn.test.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/20 16:10
 * @Version 1.0
 **/
public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler myInvocationHandler = new InvocationHandler() {
            /**
             * @Author xuyichao
             * @Description 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
             * @Date 2021/7/20 16:12
             * @param proxy 动态代理对象
             * @param method    正在执行的方法
             * @param args      调用目标方法时传入的实参
             * @return java.lang.Object
             **/
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("正在执行：" + method + " 方法。。。。。。");

                if (args != null) {
                    System.out.println("下面是执行该方法时传入的实参为：");
                    for (Object val : args) {
                        System.out.println(val);
                    }
                } else {
                    System.out.println("调用该方法没有实参");
                }

                // method.invoke(proxy, args);

                // System.out.println(proxy);

                return null;

            }
        };

        ProxyedObject obj = (ProxyedObject)Proxy.newProxyInstance(ProxyedObject.class.getClassLoader(), new Class[]{ProxyedObject.class}, myInvocationHandler);

        obj.run();
        obj.eat("鸡腿");
    }
}
