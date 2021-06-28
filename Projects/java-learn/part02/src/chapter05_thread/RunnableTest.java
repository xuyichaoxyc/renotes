package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：使用 Runnable 创建线程
 * @date ：2021/6/23 15:54
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyThreadRunnable my = new MyThreadRunnable();
        Thread thread = new Thread(my);
        thread.start();

        for (int i = 0; i < 10; i++){
            try {
                // 主线程休眠
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 主线程信息
            System.out.println("第" + i + "RunnableTest");
        }
    }
}
