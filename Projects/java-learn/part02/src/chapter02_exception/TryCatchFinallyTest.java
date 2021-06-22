package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/22 20:21
 */
public class TryCatchFinallyTest {
    public static void main(String[] args) {
        double a = Math.random();
        try{
            if(a > 0.5){
                System.out.println(a);
            }
            else
            {
                throw new Exception();
            }
        }catch (Exception e1){
            System.out.println("这是在外层捕获的异常：" + e1);
            try{
                a = 10 / 0;

            }catch (ArithmeticException em){
                System.out.println("这是在内层捕获的异常：" + em);
            }finally {
                System.out.println("这是内层的finally块");
            }
        }finally {
            System.out.println("这是外层的finally块");
        }
    }
}
