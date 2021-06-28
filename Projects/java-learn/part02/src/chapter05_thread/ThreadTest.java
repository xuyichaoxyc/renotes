package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 15:49
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread mt = new MyThread();
        // 启动线程
        mt.start();
        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 主线程打印相关信息
            System.out.println("第" + i + "ThreadDemo");
        }
    }
}
