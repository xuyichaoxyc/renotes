package com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify;

import java.util.ArrayList;

/**
 * @ClassName WaitAndNotifyTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 17:21
 * @Version 1.0
 **/
public class WaitAndNotifyTest {
    public static void main(String[] args) {
        QueueResource queue = new QueueResource(5, new ArrayList<>());
        ThreadProduct tProduct = new ThreadProduct(queue);
        ThreadConsumer tConsumer = new ThreadConsumer(queue);

        tProduct.start();
        tConsumer.start();
    }
}
