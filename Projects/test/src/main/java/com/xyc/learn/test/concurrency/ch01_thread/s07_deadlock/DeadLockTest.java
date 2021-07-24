package com.xyc.learn.test.concurrency.ch01_thread.s07_deadlock;
/**
 * @author ：xuyichao
 * @date ：Created By 2021/7/24 12:36
 * @description：线程死锁测试
 * @modified By：
 * @version: $
 */
public class DeadLockTest {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA!");
                        System.out.println("threadA try get resourceB.....");
                        Thread.sleep(1000);
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB!");
                        }
                    }
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
                    synchronized (resourceB) {
                        System.out.println("threadB get resourceB!");
                        System.out.println("threadB try get resourceA......");
                        Thread.sleep(1000);
                        synchronized (resourceA) {
                            System.out.println("threadB get resourceA!");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadB over!");
            }
        });


        threadA.start();
        threadB.start();
    }
}
