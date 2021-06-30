package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 16:22
 */
public class ThreadSleepTest {
    public static void main(String[] args) {
        FirstTest one = new FirstTest();
        SecondTest two = new SecondTest();
        ThirdTest third = new ThirdTest();

        one.start();
        two.start();
        third.start();
    }
}
class FirstTest extends Thread{
    public void run(){
        try{
            for(int a = 1; a < 5; a++){
                System.out.println("第一个线程 第" + a + "次循环" );
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("异常");
        }
    }
}

class SecondTest extends Thread{
    public void run(){
        try{
            for(int a = 1; a < 5; a++){
                System.out.println("第二个线程 第" + a + "次循环" );
                Thread.sleep(2500);
            }
        } catch (InterruptedException e) {
            System.out.println("异常");
        }
    }
}

class ThirdTest extends Thread{
    public void run(){
        try{
            for(int a = 1; a < 5; a++){
                System.out.println("第三个线程 第" + a + "次循环" );
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("异常");
        }
    }
}