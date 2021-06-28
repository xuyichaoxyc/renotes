package thread_wait_notify;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/28 23:20
 * @description：notify 实例
 * @modified By：
 * @version: 1.0.0$
 */
public class NotifyAllTest {
    static Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println("threadA begin wait...");
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadA end wait...");
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println("threadB begin wait...");
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("threadB end wait...");
                }

            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println("threadC begin notify...");
                    try {
                        resource.notifyAll();
                    } finally {

                    }
                    System.out.println("threadC end notify...");
                }

            }
        });

        threadA.start();
        threadB.start();

        Thread.sleep(1000);

        threadC.start();

        // 等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main Over");
    }
}
