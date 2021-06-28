package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/24 10:43
 */
class Resource {
    String resourceName;

    public Resource(String resourceName) {
        this.resourceName = resourceName;
    }
}

class DeadThread implements Runnable {

    Resource sc1;
    Resource sc2;

    String name;

    public DeadThread(Resource sc1, Resource sc2, String name) {
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.name = name;
    }

    @Override
    public void run() {
        // 对资源 1 同步锁定
        synchronized (sc1) {
            System.out.println(this.name + "获得 " + sc1.resourceName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "等待 " + sc2.resourceName + "释放");
        // 对资源 2 同步锁定
        synchronized (sc2) {
            System.out.println(this.name + "获得 " + sc2.resourceName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        // 创建资源对象
        Resource rs1 = new Resource("rs1");
        Resource rs2 = new Resource("rs2");
        Resource rs3 = new Resource("rs3");

        // 创建三个实现 Runnable 接口的对象
        DeadThread ms1 = new DeadThread(rs1, rs2, "线程1");
        DeadThread ms2 = new DeadThread(rs2, rs3, "线程2");
        DeadThread ms3 = new DeadThread(rs3, rs1, "线程3");

        // 创建三个线程
        Thread t1 = new Thread(ms1);
        Thread t2 = new Thread(ms2);
        Thread t3 = new Thread(ms3);

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
