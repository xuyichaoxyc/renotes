package com.xyc.learn.test.concurrency.ch01_thread.s02_wait_notify;

import java.util.List;

/**
 * @ClassName QueueResource
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 17:09
 * @Version 1.0
 **/
public class QueueResource {
    private int MaxSize;
    private List<Integer> queue;

    public QueueResource(int maxSize, List<Integer> queue) {
        MaxSize = maxSize;
        this.queue = queue;
    }

    public int getMaxSize() {
        return MaxSize;
    }

    public void setMaxSize(int maxSize) {
        MaxSize = maxSize;
    }

    public List<Integer> getQueue() {
        return queue;
    }

    public void setQueue(List<Integer> queue) {
        this.queue = queue;
    }
}
