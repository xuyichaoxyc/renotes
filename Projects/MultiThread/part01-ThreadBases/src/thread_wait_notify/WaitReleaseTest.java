package thread_wait_notify;

import java.io.ObjectInputStream;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/28 22:52
 * @description：wait 方法阻塞线程实例
 * @modified By：
 * @version: 1.0.0$
 */
public class WaitReleaseTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");
                        // 获取 共享资源 resourceB 的监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");

                            // 线程 A 阻塞，并释放获取到的 resourceA 的锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 休眠 1 s
                    Thread.sleep(1000);

                    // 获取共享资源 resourceA 的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");

                        System.out.println("threadB try get resourceB lock");
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB lock");

                            // 线程 B 阻塞，并释放获取到的 resourceA 的锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

        // 等待两个线程结束
        threadA.join();
        threadB.join();

        System.out.println("main Over");
    }
}
