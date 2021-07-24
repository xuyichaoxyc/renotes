package com.xyc.learn.test.concurrency.ch01_thread.s10_threadlocal;

/**
 * @ClassName ThreadLocalTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/24 13:32
 * @Version 1.0
 **/
public class InheritedThreadLocalTest {

    static ThreadLocal<String> localVariable = new InheritableThreadLocal<>();

    static void print(String string) {
        System.out.println(string + ": " + localVariable.get());
        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadA local variable");
                print("threadA");
                System.out.println("after remove: " + localVariable.get());
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadB local variable");
                print("threadB");
                System.out.println("after remove: " + localVariable.get());
            }
        });

        localVariable.set("main local variable");

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("localVariable: " + localVariable.get());
            }
        });


        threadA.start();
        threadB.start();

        threadC.start();

        System.out.println("main thread local: " + localVariable.get());
    }
}
