package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：异常处理之获取异常信息
 * @date ：2021/6/22 20:07
 */
public class TryCatchTest {
    public static void main(String[] args) {
        int a, b;
        try{
            a = 0;
            b = 5 / a;
            System.out.println("检验程序......");
        }catch (ArithmeticException e){
            System.out.println("发生了 ArithmeticException 异常");
        }
        System.out.println("程序结束");
    }
}
