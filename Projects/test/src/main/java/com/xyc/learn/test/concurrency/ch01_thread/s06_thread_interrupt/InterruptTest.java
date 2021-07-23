package com.xyc.learn.test.concurrency.ch01_thread.s06_thread_interrupt;

/**
 * @ClassName InterruptTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 22:19
 * @Version 1.0
 **/
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " hello!");
                }
            }
        });

        thread.start();

        Thread.sleep(1);

        System.out.println("main thread interrupt child interrupt");
        thread.interrupt();

        // 等待子线程结束
        thread.join();

        System.out.println("main is over");
    }
}
