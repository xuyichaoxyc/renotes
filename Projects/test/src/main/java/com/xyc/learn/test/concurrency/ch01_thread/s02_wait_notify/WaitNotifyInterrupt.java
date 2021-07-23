package com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify;

/**
 * @ClassName WaitNotifyInterrupt
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 20:46
 * @Version 1.0
 **/
public class WaitNotifyInterrupt {
    private static Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("====== thread begin ======");
                    synchronized (resource) {
                        // 阻塞线程
                        resource.wait();
                    }
                    System.out.println("====== thread end ======");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("====== begin interrupt thread ======");
        thread.interrupt();
        System.out.println("====== end interrupt thread ======");
    }
}
