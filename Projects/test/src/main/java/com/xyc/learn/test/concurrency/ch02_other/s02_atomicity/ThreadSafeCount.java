package com.xyc.learn.test.concurrency.ch02_other.s02_atomicity;

/**
 * @ClassName ThreadSafeCount
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 17:03
 * @Version 1.0
 **/
public class ThreadSafeCount {
    private Long value;

    public synchronized Long get() {
        return value;
    }

    public synchronized void set() {
        ++value;
    }
}
