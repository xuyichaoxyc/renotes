package chapter03_Array;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 10:31
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        // 出现异常 ArrayIndexOutOfBoundsException
        System.out.println(array1[5]);
    }
}
