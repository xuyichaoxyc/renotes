package com.xyc.learn.test.concurrency.ch01_thread.s08_daemon_user;

/**
 *@ClassName JvmExitTest
 *@Description TODO
 *@Author xuyichao-xuyichao
 *@Date 2021/7/24 12:49
 *@Version 1.0
 **/
public class JvmExitTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        System.out.println("main thread is over!");
    }
}
