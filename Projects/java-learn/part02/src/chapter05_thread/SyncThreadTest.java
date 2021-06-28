package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：线程同步测试
 * @date ：2021/6/24 10:12
 */

class Source {
    /**
     * @author: xuyichao
     * @description: 同步方法1
     * @date: 2021/6/24 10:13
     * @param
     * @return void
     */
    synchronized void method1() {
        System.out.println("进入方法 method1，获得锁");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1 执行完毕，释放锁");
    }

    /**
     * @author: xuyichao
     * @description: 同步方法2
     * @date: 2021/6/24 10:15
     * @param
     * @return void
     */
    synchronized void method2(){
        System.out.println("进入方法 method2，获得锁");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method2 执行完毕，释放锁");
    }
}

// 定义线程类
class SyncThread implements Runnable{
    String name;
    Source s = null;

    public SyncThread(String name, Source s) {
        this.name = name;
        this.s = s;
    }

    @Override
    public void run() {
        if("method1".equals(name)) {
            s.method1();
        }
        else {
            System.out.println("Thread2 启动，准备调用 method2");
            s.method2();
        }
    }
}

public class SyncThreadTest {
    public static void main(String[] args) {
        Source s = new Source();

        SyncThread st1 = new SyncThread("method1", s);
        SyncThread st2 = new SyncThread("method2", s);

        Thread t1 = new Thread(st1);
        Thread t2 = new Thread(st2);

        t1.start();
        t2.start();
    }
}
