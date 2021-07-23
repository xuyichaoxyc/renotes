package com.xyc.learn.test.concurrency.ch01_thread.s01_create_start;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName ThreadCreateTest
 * @Description 线程的创建和运行
 * @Author admin-xuyichao
 * @Date 2021/7/23 16:22
 * @Version 1.0
 **/
public class ThreadCreateTest {
    /**
     * @ClassName MyThreadA
     * @Description 线程创建方式一：继承 Thread 类，并重写 run 方法
     * @Author admin-xuyichao
     * @Date 2021/7/23 16:22
     * @Version 1.0
     **/
    public static class MyThreadA extends Thread {
        @Override
        public void run() {
            System.out.println("threadA: I am a child thread by extending class Thread!");
        }
    }

    /**
     * @ClassName MyThreadB
     * @Description 线程创建方式二：实现 Runnable 接口，并重写 run 方法
     * @Author admin-xuyichao
     * @Date 2021/7/23 16:22
     * @Version 1.0
     **/
    public static class MyThreadB implements Runnable {
        @Override
        public void run() {
            System.out.println("threadB: I am a child thread by implementing interface Runnable");
        }
    }

    /**
     * @ClassName MyThreadA
     * @Description 线程创建方式三： FutureTask 方式
     * @Author admin-xuyichao
     * @Date 2021/7/23 16:22
     * @Version 1.0
     **/
    public static class MyThreadC implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "threadC: I am a child thread by implementing interface Callable";
        }
    }

    public static void main(String[] args) {
        // 方式一创建线程
        MyThreadA threadA = new MyThreadA();

        // 方式二创建线程
        Thread threadB = new Thread(new MyThreadB());

        // 方式三创建线程, 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new MyThreadC());
        Thread threadC = new Thread(futureTask);

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            // 等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
