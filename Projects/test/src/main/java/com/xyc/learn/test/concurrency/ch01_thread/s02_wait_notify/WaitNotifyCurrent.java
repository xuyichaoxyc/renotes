package com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify;

/**
 * @ClassName WaitNotifyCurrent
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 17:32
 * @Version 1.0
 **/
public class WaitNotifyCurrent {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA try get resourceA......");
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA!");
                        System.out.println("threadA try get resourceB......");
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB!");
                            System.out.println("threadA release resourceB!");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("threadB try get resourceA......");
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA!");
                        System.out.println("threadB try get resourceB......");
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB!");
                            System.out.println("threadB release resourceA");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        // 启动两个线程
        threadA.start();
        threadB.start();

        // 等待两个线程结束
        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}
