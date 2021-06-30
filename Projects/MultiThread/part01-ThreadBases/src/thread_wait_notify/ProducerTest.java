package thread_wait_notify;

import java.util.Queue;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/28 22:35
 * @description：生产者
 * @modified By：
 * @version: 1.0.0$
 */
public class ProducerTest extends Thread{
    private Queue queue;
    private final int MAX_SIZE = 10;

    public ProducerTest(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while(queue.size() == this.MAX_SIZE){
                    try {
                        System.out.println("生产者线程阻塞中....");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产者线程进行生产....");
                queue.add(Math.random());
                queue.notify();
            }
        }

    }
}
