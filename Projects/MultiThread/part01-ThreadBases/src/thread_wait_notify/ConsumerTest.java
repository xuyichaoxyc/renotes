package thread_wait_notify;

import java.util.Queue;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/28 22:39
 * @description：消费者
 * @modified By：
 * @version: 1.0.0$
 */
public class ConsumerTest extends Thread {
    private Queue queue;

    public ConsumerTest(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        System.out.println("消费者线程阻塞中....");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前队列存有" + queue.size() + "; 消费者线程消费中....");
                System.out.println(queue.poll());
                queue.notify();
            }
        }

    }
}
