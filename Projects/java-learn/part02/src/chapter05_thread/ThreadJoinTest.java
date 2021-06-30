package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 16:35
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        FirstTest1 one = new FirstTest1();
        SecondTest1 two = new SecondTest1(one);
        ThirdTest1 third = new ThirdTest1();

        one.start();
        two.start();
        third.start();
    }
}

class FirstTest1 extends Thread{
    public void run(){
        try{
            for(int a = 1; a < 10; a++){
                System.out.println("第一个线程 第" + a + "次循环" );
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("异常");
        } finally {

        }
    }
}

class SecondTest1 extends Thread{
    public FirstTest1 firstTest1;

    SecondTest1(FirstTest1 t){
        this.firstTest1 = t;
    }
    public void run(){
        for(int a = 1; a < 10; a++){
            try{
                System.out.println("第二个线程 第" + a + "次循环" );
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("异常");
            }
            if(a == 4){
                try {
                    firstTest1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class ThirdTest1 extends Thread{
    public void run(){
        try{
            for(int a = 1; a < 10; a++){
                System.out.println("第三个线程 第" + a + "次循环" );
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("异常");
        }
    }
}
