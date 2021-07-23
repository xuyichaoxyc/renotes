package com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify;

/**
 * @ClassName NotifyAll
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 21:25
 * @Version 1.0
 **/
public class NotifyAll {
    private volatile static Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println("threadA get resource!");

                    try {
                        System.out.println("threadA begin wait.......");
                        resource.wait();
                        System.out.println("threadA end wait......");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println("threadB get resource!");

                    try {
                        System.out.println("threadB begin wait......");
                        resource.wait();
                        System.out.println("threadB end wait......");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println("threadC begin notify......");
                    resource.notifyAll();
//                    resource.notify();
                    System.out.println("threadC end notify!");
                }
            }
        });

        threadA.start();
        threadB.start();

//        Thread.sleep(1000);

        threadC.start();


        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
