package chapter03_Array;

/**
 * @author ：xuyichao
 * @description：数组冒泡排序
 * @date ：2021/6/17 11:17
 */
public class ArrayBubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {1, 23, 45, 66, 2, 332, 8, 5};
        int tmp;

        System.out.println("冒泡排序前数组值为：");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println("冒泡排序后数组值为：");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
