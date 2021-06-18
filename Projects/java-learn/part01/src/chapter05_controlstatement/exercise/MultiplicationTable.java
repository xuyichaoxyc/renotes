package chapter05_controlstatement.exercise;

/**
 * @author ：xuyichao
 * @description：输出 九九乘法表
 * @date ：2021/6/17 15:09
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i + " * " + j + " = " + i * j + "      ");
            }
            System.out.println();
        }
    }
}
