package com.xyc.learn.test.concurrency.ch01_thread.s06_thread_interrupt;

/**
 * @ClassName InterruptMarkTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 22:37
 * @Version 1.0
 **/
public class InterruptMarkTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(!Thread.currentThread().interrupted())
                while(!Thread.interrupted()){

                }
                System.out.println("thread isInterrupted: " + Thread.currentThread().isInterrupted());
            }
        });

        thread.start();

        thread.interrupt();

        thread.join();

        System.out.println("main is over");
    }
}
