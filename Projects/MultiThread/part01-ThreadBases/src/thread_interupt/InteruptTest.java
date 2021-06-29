package thread_interupt;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/29 11:28
 */
public class InteruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread() + " : " + i++ + " hello");
                }
            }
        });
        // 启动子线程
        thread.start();

        // 主线程休眠 1 秒，以便中断前让子线程输出
        Thread.sleep(1000);

        // 中断子线程
        System.out.println("main thread interrupt child thread");
        thread.interrupt();

        // 等待子线程执行完毕
        thread.join();
        System.out.println("main thread is over");
    }


}
