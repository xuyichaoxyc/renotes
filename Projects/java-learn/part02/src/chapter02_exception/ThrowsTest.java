package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：异常声明
 * @date ：2021/6/22 20:14
 */
public class ThrowsTest {
    public void methodName(int a) throws ArrayIndexOutOfBoundsException,
            ArithmeticException{
        System.out.println(a);
        if(a == 0){
            System.out.println("没有异常");
            return;
        }
        else if(a == 1){
            int[] x = new int[3];
            x[3] = 5;
        }
        else if (a == 2){
            int i = 0;
            int j = 50 / i;
        }
    }

    public static void main(String[] args) {
        ThrowsTest tt = new ThrowsTest();
        try{
            tt.methodName(0);
        }catch (Exception e){
            System.out.println("异常是：" + e);
        }

        try{
            tt.methodName(1);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("异常是：" + e);
        }

        try{
            tt.methodName(2);
        }catch (ArithmeticException e){
            System.out.println("异常是：" + e);
        }

    }

}
