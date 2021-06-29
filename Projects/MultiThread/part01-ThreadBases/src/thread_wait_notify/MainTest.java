package thread_wait_notify;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/28 22:42
 * @description：生产者消费者线程等待与唤醒测试
 * @modified By：
 * @version: 1.0.0$
 */
public class MainTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        ProducerTest producer = new ProducerTest(queue);
        ConsumerTest consumer = new ConsumerTest(queue);

        producer.start();
        consumer.start();
    }
}

