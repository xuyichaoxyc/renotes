package thread_interupt;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/29 12:16
 */
public class InterruptedTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {

                }
                System.out.println("child thread is interrupted：" + Thread.currentThread().isInterrupted());
            }
        });

        // 启动线程
        thread.start();

        // 设置中断标识
        thread.interrupt();

        // 获取中断标识
        System.out.println("isInterrupted：" + thread.isInterrupted());

        // 获取中断标志并重置
        System.out.println("isInterrupted：" + thread.interrupted());

        // 获取中断标识并重置
        System.out.println("isInterrupted：" + Thread.interrupted());

        // 获取中断标识
        System.out.println("isInterrupted：" + thread.isInterrupted());

        thread.join();

        System.out.println("main thread is over.");
    }
}
