package com.xyc.learn.test.concurrency.ch02_other.s02_atomicity;

/**
 * @ClassName ThreadNotSafeCount
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 17:02
 * @Version 1.0
 **/
public class ThreadNotSafeCount {
    private Long value;

    public Long getCount() {
        return value;
    }

    public void inc() {
        ++value;
    }
}
