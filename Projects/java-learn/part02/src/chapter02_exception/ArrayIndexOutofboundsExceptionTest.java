package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：访问越界示例
 * @date ：2021/6/22 20:02
 */
public class ArrayIndexOutofboundsExceptionTest {
    public static void main(String[] args) {
        int[] i = new int[]{1, 2, 3, 4, 5};
        for(int j = 0; j < 6; j++){
            System.out.println(i[j]);
        }
    }
}
