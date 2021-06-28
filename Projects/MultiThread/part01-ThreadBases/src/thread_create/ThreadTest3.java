package thread_create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：xuyichao
 * @description：线程创建方式三：FutureTask
 * @date ：2021/6/28 14:28
 */
public class ThreadTest3 {
    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Hello";
        }
    }

    public static void main(String[] args) {
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());

        // 启动线程
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
