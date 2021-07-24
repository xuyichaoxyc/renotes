package com.xyc.learn.test.concurrency.ch02_other.s03_cas_unsafe;

import sun.misc.Unsafe;

/**
 * @ClassName ObjectFieldOffsetTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 17:09
 * @Version 1.0
 **/
public class TestUnSafe {
    static final Unsafe unsafe = Unsafe.getUnsafe();

    static final long stateOffset;

    private volatile long state = 0;

    static{
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();
        Boolean success = unsafe.compareAndSwapLong(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
