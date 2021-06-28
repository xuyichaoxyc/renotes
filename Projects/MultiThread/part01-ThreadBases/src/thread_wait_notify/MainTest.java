package thread_wait_notify;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ：xuyichao
 * @description：生产者消费者线程
 * @date ：2021/6/28 15:12
 */
public class MainTest {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        // 创建生产者线程
        ProductThread productThread = new ProductThread(queue);
        // 创建消费者线程
        ConsumerThread consumerThread = new ConsumerThread(queue);


    }
}
