package com.xyc.learn.test.base.proxytest.AopTest;

/**
 * @ClassName GunDog
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/20 16:29
 * @Version 1.0
 **/
public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("猎狗");
    }

    @Override
    public void run() {
        System.out.println("奔跑迅速");
    }
}
