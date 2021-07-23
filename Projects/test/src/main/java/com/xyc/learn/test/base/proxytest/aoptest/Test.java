package com.xyc.learn.test.base.proxytest.aoptest;

/**
 * @ClassName Test
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/20 16:39
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Dog target = new GunDog();

        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
