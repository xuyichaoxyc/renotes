package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：继承 Thread 类来创建线程
 * @date ：2021/6/23 15:42
 */
public class MyThread extends Thread{
    // 重写run方法
    public void run(){
        for(int i = 0; i < 10; i++){
            try{
                // 调用 sleep 让当前线程休眠
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 在线程中打印相关信息
            System.out.println("第" + i + "MyThread");
        }
    }
}
