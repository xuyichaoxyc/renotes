package chapter03_Array;

/**
 * @author ：xuyichao
 * @description：数组的选择排序
 * @date ：2021/6/17 11:11
 */
public class ArraySelectSortTest {
    public static void main(String[] args) {
        int[] arr = {1, 23, 45, 66, 2, 332, 8, 5};
        int min;
        int tmp;

        System.out.println("选择排序前数组值为：");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < arr.length; i++){
            min = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        System.out.println("选择排序后数组值为：");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
