package com.xyc.learn.test.concurrency.ch01_thread.s06_thread_interrupt;

import com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify.ThreadConsumer;

/**
 * @ClassName InterruptTest1
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 22:23
 * @Version 1.0
 **/
public class InterruptTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("threadA awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadA is interrupted while sleeping");
//                    return;
                }
                System.out.println("threadA-leaving normally");
            }
        });

        threadA.start();

        Thread.sleep(1000);

        threadA.interrupt();

        System.out.println("main thread is over");
    }
}
