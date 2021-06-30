package thread_join;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/29 9:47
 */
public class JoinInteruptTest {
    public static void main(String[] args) {
        // 创建线程 threadOne，无线循环
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne start......");
                for (; ; ) {

                }
            }
        });

        // 获取当前主线程
        final Thread threadMain = Thread.currentThread();

        // 创建线程 threadTwo，中断主线程
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                threadMain.interrupt();
            }
        });


        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("threadMain：");
            e.printStackTrace();
        }
    }
}
