package com.xyc.learn.test.concurrency.ch02_other.s01_memory_visibility;

/**
 * @ClassName ThreadNotSafeInteger
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 16:57
 * @Version 1.0
 **/
public class ThreadNotSafeInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set() {
        this.value = value;
    }
}
