package com.xyc.learn.test.concurrency.ch01_thread.s08_daemon_user;
/**
 * @author ：xuyichao
 * @date ：Created By 2021/7/24 12:47
 * @description：创建一个守护线程
 * @modified By：
 * @version: $
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread DaemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am a Daemon thread!");
            }
        });

        DaemonThread.setDaemon(true);
        DaemonThread.start();
    }
}
