package thread_create;

/**
 * @author ：xuyichao
 * @description：线程创建方式一：实现 Runnable 接口
 * @date ：2021/6/28 14:25
 */
public class ThreadTest2 {
    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
    }
}
