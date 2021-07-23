package com.xyc.learn.test.concurrency.ch01_thread.s04_sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SleepTeste
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 21:51
 * @Version 1.0
 **/
public class SleepTest {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();

                try {
                    System.out.println("threadA is in sleep");
                    Thread.sleep(1000);
                    System.out.println("threadA is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放独占锁
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    System.out.println("threadB is in sleep");
                    Thread.sleep(1000);
                    System.out.println("threadB is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
    }
}
