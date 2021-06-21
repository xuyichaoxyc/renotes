package chapter01_digital_processing;

import java.util.Scanner;

/**
 * @author ：xuyichao
 * @description：猜数字游戏
 * @date ：2021/6/21 12:15
 */
public class GameTest {
    public static void main(String[] args) {
        System.out.println("猜数字游戏");
        int guess = (int)MathTest();
        int num;
        boolean right = true;
        while (right){
            System.out.println("请输入一个整型数字1-100之间：");
            Scanner scan = new Scanner(System.in);
            num = scan.nextInt();
            if(num > guess){
                System.out.println("输入数字大于该数字：请重新输入：");

            }
            else if(num < guess){
                System.out.println("输入数字小于该数字：请重新输入：");

            }
            else{
                System.out.println("恭喜您猜对了！");
                System.out.println("这个数就是：" + guess);
                right = false;
            }
        }
    }

    /**
     * 用于生产一个随机数
     *
     * @return 随机数
     */
     public static double MathTest(){
         double mathTest = Math.random() * 100;
         return mathTest;
     }
}

