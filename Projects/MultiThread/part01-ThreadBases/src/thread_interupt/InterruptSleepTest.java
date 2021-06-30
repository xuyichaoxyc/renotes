package thread_interupt;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/29 12:10
 */
public class InterruptSleepTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread begin sleep......");
                    Thread.sleep(2000000);
                    System.out.println("child thread end sleep......");
                } catch (InterruptedException e) {
                    System.out.println("从中断处退出");
                    e.printStackTrace();
                    return;
                }

                System.out.println("child thread leaving normally");
            }
        });

        thread.start();

        // 主线程休眠，确保子线程进入睡眠
        Thread.sleep(1000);

        // 打断子线程休眠
        thread.interrupt();

        // 等待子线程执行完毕
        thread.join();

        System.out.println("main thread is over");
    }
}
