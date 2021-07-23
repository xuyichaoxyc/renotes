package com.xyc.learn.test.concurrency.ch01_thread.s05_yield;

import com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify.ThreadConsumer;

/**
 * @ClassName YieldTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 22:05
 * @Version 1.0
 **/
public class YieldTest implements Runnable {
    YieldTest() {
        // 创建并启动线程
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 5 == 0) {
                System.out.println(Thread.currentThread() + "yield cpu......");

                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();

        new YieldTest();

        System.out.println(Thread.currentThread());
    }
}
