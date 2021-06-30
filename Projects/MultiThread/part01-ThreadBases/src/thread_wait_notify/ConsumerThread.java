package thread_wait_notify;

import java.util.Queue;

/**
 * @author ：xuyichao
 * @description：消费者线程
 * @date ：2021/6/28 15:07
 */
public class ConsumerThread extends Thread{
    Queue queue;
    public ConsumerThread(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            /**
             * 消费队列空
             * 这里使用循环，避免虚假唤醒问题（在未 notify 的情况下从挂起状态进入可执行状态）
             */
            while (queue.size() == 0) {
                try{
                    // 挂起当前线程，并释放通过同步块获取的 queue 上的锁，让消费者线程可以获取该锁，然后获取队列里面的元素
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(queue.poll());
            queue.notify();
        }
    }
}
