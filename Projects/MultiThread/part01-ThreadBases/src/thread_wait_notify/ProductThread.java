package thread_wait_notify;

import java.util.Queue;
import java.util.Random;

/**
 * @author ：xuyichao
 * @description：生产线程
 * @date ：2021/6/28 15:02
 */
public class ProductThread extends Thread{
    Queue queue;
    final int MAX_SIZE = 10;
    public ProductThread(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            /**
             * 消费队列满，则等待队列空闲
             * 这里使用循环，避免虚假唤醒问题（在未 notify 的情况下从挂起状态进入可执行状态）
             */
            while (queue.size() == MAX_SIZE) {
                try{
                    // 挂起当前线程，并释放通过同步块获取的 queue 上的锁，让消费者线程可以获取该锁，然后获取队列里面的元素
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 空闲则生成元素，并通知消费者线程
            queue.add("" + Math.random());
            queue.notify();

        }
    }
}
