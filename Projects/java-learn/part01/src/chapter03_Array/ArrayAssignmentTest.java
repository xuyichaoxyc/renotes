package chapter03_Array;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 10:37
 */
public class ArrayAssignmentTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[5];
        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;
        array2[3] = 4;
        array2[4] = 5;

        for (int i = 0; i < 5; i++){
            System.out.println("数组 array[" + i + "]的值为：" + array[i]);
            System.out.println("数组 array1[" + i + "]的值为：" + array1[i]);
            System.out.println("数组 array2[" + i + "]的值为：" + array2[i]);
        }
    }
}
