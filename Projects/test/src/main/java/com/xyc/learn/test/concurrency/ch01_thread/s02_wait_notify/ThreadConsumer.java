package com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify;

/**
 * @ClassName ThreadConsumer
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 17:16
 * @Version 1.0
 **/
public class ThreadConsumer extends Thread {
    private QueueResource queue;

    public ThreadConsumer() {

    }

    public ThreadConsumer(QueueResource resource) {
        this.queue = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.getQueue().size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int result = queue.getQueue().remove(queue.getQueue().size() - 1);
                System.out.println("ThreadConsumer: " + result);
                queue.notifyAll();
            }
        }

    }
}
