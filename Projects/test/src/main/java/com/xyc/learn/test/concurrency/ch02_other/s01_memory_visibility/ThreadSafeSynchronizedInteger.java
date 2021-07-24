package com.xyc.learn.test.concurrency.ch02_other.s01_memory_visibility;

/**
 * @ClassName ThreadSafeInteger
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 16:58
 * @Version 1.0
 **/
public class ThreadSafeSynchronizedInteger {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set() {
        this.value = value;
    }
}
