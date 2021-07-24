package com.xyc.learn.test.concurrency.ch02_other.s01_memory_visibility;

/**
 * @ClassName ThreadSafeVolatileInteger
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 16:59
 * @Version 1.0
 **/
public class ThreadSafeVolatileInteger {
    private volatile int value;

    public int get() {
        return value;
    }

    public void set() {
        this.value = value;
    }
}
