package chapter05_controlstatement.exercise;

/**
 * @author ：xuyichao
 * @description：打印菱形
 * @date ：2021/6/17 15:18
 */
public class DiamondPrint {
    public static void diamondPrint(int row){
        if(row >= 1){
            int x, y;
            for(x = 1; x <= row; x++){
                for(y = 1; y <= row - x; y++){
                    System.out.print(" ");
                }
                for(y = 1; y <= 2 * x; y++){
                    System.out.print("#");
                }
                System.out.println();
            }
            for(x = 1; x <= row; x++){
                for(y = 1; y <= x; y++){
                    System.out.print(" ");
                }
                for(y = 1; y <= 2 * (row - x) - 1; y++){
                    System.out.print("#");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        diamondPrint(5);
    }
}
