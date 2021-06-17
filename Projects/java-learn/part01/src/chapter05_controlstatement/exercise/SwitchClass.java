package chapter05_controlstatement.exercise;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 15:13
 */
public class SwitchClass {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int i;
        do{
            System.out.println("1：数据结构");
            System.out.println("2：计算机网络");
            System.out.println("3：操作系统");
//            i = (int)System.in.read();
            i = scan.nextInt();
            switch (i){
                case 1:
                    System.out.println("选择了数据结构");
                    break;
                case 2:
                    System.out.println("选择了计算机网络");
                    break;
                case 3:
                    System.out.println("选择了操作系统");
                    break;

                default:
                    System.out.println("输入错误，请重新选择");
            }
        }
        while(i <= 3 && i >= 1);

    }
}
