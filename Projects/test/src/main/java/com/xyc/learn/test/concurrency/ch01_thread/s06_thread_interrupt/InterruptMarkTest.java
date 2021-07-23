package com.xyc.learn.test.concurrency.ch01_thread.s06_thread_interrupt;

/**
 * @ClassName InterruptMarkTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 22:37
 * @Version 1.0
 **/
public class InterruptMarkTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        thread.start();

        thread.interrupt();

        System.out.println("isInterrupted: " + thread.isInterrupted());
//        System.out.println("isInterrupted: " +  thread.interrupted());
        System.out.println("isInterrupted: " + Thread.interrupted());
        System.out.println("isInterrupted: " + thread.isInterrupted());

        thread.join();

        System.out.println("main is over");
    }
}
