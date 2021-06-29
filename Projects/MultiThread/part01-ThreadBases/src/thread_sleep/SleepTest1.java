package thread_sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/29 10:47
 */
public class SleepTest1 {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadA is in sleeping......");
                    Thread.sleep(1000);
                    System.out.println("threadA is in awaking......");
                } catch (InterruptedException e) {
                    System.out.println("threadA 中断异常：");
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadB is in sleeping......");
                    Thread.sleep(1000);
                    System.out.println("threadB is in awaking......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();

    }
}
