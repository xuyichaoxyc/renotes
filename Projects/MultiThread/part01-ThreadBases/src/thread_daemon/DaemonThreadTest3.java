package thread_daemon;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/29 18:57
 */
public class DaemonThreadTest3 {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        // 设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("main is over.");
    }
}
