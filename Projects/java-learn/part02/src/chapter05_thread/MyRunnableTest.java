package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 16:12
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        // 创建实现 Runnable 接口类的对象
        RunnableThread rt = new RunnableThread();
        Thread t = new Thread(rt);
        // 启动线程
        t.start();
    }
}

class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("线程已经被启动， 执行了 run 方法中的代码！");
    }
}
