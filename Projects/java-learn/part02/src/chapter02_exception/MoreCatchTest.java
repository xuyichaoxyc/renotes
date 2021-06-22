package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/22 20:11
 */
public class MoreCatchTest {
    public static void main(String[] args) {
        int[] a = new int[3];
        try{
            a[3] = 10;
            System.out.println("检测程序......");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("发生ArrayIndexOutOfBoundsException异常！");
        }catch (ArithmeticException e1){
            System.out.println("发生 ArithmeticException 异常！");
        }catch (Exception e2){
            System.out.println("发生 Exception 异常！");
        }
        System.out.println("程序异常");
    }
}
