package com.xyc.learn.test.concurrency.ch02_other.s03_cas_unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName ObjectFieldOffsetTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 17:09
 * @Version 1.0
 **/
public class TestUnSafe2 {
    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnSafe2.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe2 test = new TestUnSafe2();
        Boolean success = unsafe.compareAndSwapLong(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
