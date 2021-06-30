package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/24 9:42
 */
public class ThreadYieldTest {
    public static void main(String[] args) {
        FirstTest2 one = new FirstTest2();
        SecondTest2 two = new SecondTest2();
        ThirdTest2 third = new ThirdTest2();

        one.start();
        two.start();
        third.start();
    }
}

class FirstTest2 extends Thread{
    public void run(){
        try{
            for(int a = 1; a < 10; a++){
                System.out.println("第一个线程 第" + a + "次循环" );
//                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("异常");
        } finally {

        }
    }
}

class SecondTest2 extends Thread{
//    public FirstTest2 firstTest2;
//
//    SecondTest2(FirstTest2 t){
//        this.firstTest2 = t;
//    }
    public void run(){
        for(int a = 1; a < 10; a++){
            try{
                System.out.println("第二个线程 第" + a + "次循环" );
//                Thread.sleep(1000);
                Thread.yield();
            } catch (Exception e) {
                System.out.println("异常");
            }
//            if(a == 4){
//                try {
//                    firstTest1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

    }
}

class ThirdTest2 extends Thread{
    public void run(){
        try{
            for(int a = 1; a < 10; a++){
                System.out.println("第三个线程 第" + a + "次循环" );
//                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
    }
}