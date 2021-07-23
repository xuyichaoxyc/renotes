package com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify;

import java.util.Random;

/**
 * @ClassName ThreadProduct
 * @Description 生产者线程
 * @Author admin-xuyichao
 * @Date 2021/7/23 16:47
 * @Version 1.0
 **/
public class ThreadProduct extends Thread {
    private QueueResource queue;

    public ThreadProduct() {

    }

    public ThreadProduct(QueueResource resource) {
        this.queue = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.getQueue().size() >= queue.getMaxSize()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.getQueue().add((int) (Math.random() * 10));
                System.out.println("ThreadProduct: " + queue.getQueue().get(queue.getQueue().size()-1));
                queue.notifyAll();
            }
        }
    }
}
