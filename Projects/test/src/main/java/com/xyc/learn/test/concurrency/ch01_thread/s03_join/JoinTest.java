package com.xyc.learn.test.concurrency.ch01_thread.s03_join;

import com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify.ThreadConsumer;

/**
 * @ClassName JoinTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 21:38
 * @Version 1.0
 **/
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadA over!");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadB over!");
            }
        });

        threadA.start();
        threadB.start();

        System.out.println("wait all child thread over......");

        // 等待子线程返回
        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}
