package thread_deadlock;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/29 14:09
 */
public class DeadLockTest {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("threadA try to get resourceB");
                    synchronized (resourceB) {
                        System.out.println("threadA get resourceB");
                    }
                }
            }
        });


        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println("threadB get resourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("threadB try to get resourceA");
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA");
                    }
                }
            }
        });


        // 启动线程
        threadA.start();
        threadB.start();
    }
}
