package com.xyc.learn.test.concurrency.ch01_thread.s04_sleep;

/**
 * @ClassName SleepInterruptTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 21:58
 * @Version 1.0
 **/
public class SleepInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread is in sleep");
                    Thread.sleep(100000);
                    System.out.println("thread is in awaked");
                } catch (InterruptedException e) {
                    System.out.println("thread is interrupted\n" + e);
                }
            }
        });

        thread.start();

        Thread.sleep(2000);

        thread.interrupt();

        System.out.println("main over!");
    }
}
