package thread_wait_notify;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/28 23:03
 * @description：wait 方法中断实例
 * @modified By：
 * @version: 1.0.0$
 */
public class WaitNotifyInterupt {
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("------ begin ------");
                synchronized (obj) {
                    try {
                        obj.wait();
                        System.out.println("此处无法运行");
                    } catch (InterruptedException e) {
                        System.out.println("中断返回至此");
                        e.printStackTrace();
                    }
                }
                System.out.println("------ end ------");
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("------ Interupt begin ------");
        threadA.interrupt();
        System.out.println("------ Interupt end ------");

    }
}
