package chapter03_Array;

import java.util.Arrays;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 10:53
 */
public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        System.out.println("两个数组的初始值：");
        for(int i = 0; i < arr1.length; i++){
            System.out.println("arr1[" + i + "] = " + arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }

        /**
         * 将 arr2 赋值 给 arr1，此处并不是真正的复制
         * 仅仅将arr1 以及 arr2 两个引用指向了 原始 arr2 指向的堆中的数组
         */
        arr1 = arr2;
        System.out.println("赋值后两个数组的值：");
        for(int i = 0; i < arr1.length; i++){
            System.out.println("arr1[" + i + "] = " + arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }

        /**
         * 修改了 arr1 数组，arr2 数组同时改变，
         * 说明仅复制了引用
         * 浅克隆
         */
        System.out.println("修改第一个元素值后两个数组的值：");
        arr1[0] = 9;
        for(int i = 0; i < arr1.length; i++){
            System.out.println("arr1[" + i + "] = " + arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }

        arr2 = new int[]{1, 2, 3};

        arr1 = Arrays.copyOf(arr2, 3);
        System.out.println("真正克隆后两个数组的值：");
        for(int i = 0; i < arr1.length; i++){
            System.out.println("arr1[" + i + "] = " + arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }

        arr1[0] = 8;
        System.out.println("改变第一个元素后两个数组的值：");
        for(int i = 0; i < arr1.length; i++){
            System.out.println("arr1[" + i + "] = " + arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }

    }
}
