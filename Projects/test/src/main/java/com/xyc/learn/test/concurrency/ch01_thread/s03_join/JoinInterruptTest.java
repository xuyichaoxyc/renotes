package com.xyc.learn.test.concurrency.ch01_thread.s03_join;

/**
 * @ClassName JoinInterruptTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 21:46
 * @Version 1.0
 **/
public class JoinInterruptTest {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin running......");
                for (; ; ) {

                }
            }
        });

        final Thread mainThread = Thread.currentThread();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });

        threadA.start();

        threadB.start();

        try {
            threadA.join();
        } catch (InterruptedException e) {
            System.out.println("main thread interrupt\n" + e);
        }
    }
}
