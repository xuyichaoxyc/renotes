package chapter05_controlstatement;

/**
 * @author ：xuyichao
 * @description：switch 语句
 * @date ：2021/6/17 14:44
 */
public class SwitchTest {
    public static void main(String[] args) {
        /**
         * switch 语句语法格式：
         * switch(表达式){
         *     case value1:
         *         statement1;
         *         break;
         *     case value2:
         *         statement2;
         *         break;
         *     case value3:
         *          statement3;
         *          break;
         *     ......
         *     default:
         *         statment;
         *         break;
         * }
         *
         * int、char、Enum、String
         *
         */

        int i = 2;
        switch (i){
            case 1:
                System.out.println("今天是星期一");
                break;
            case 2:
                System.out.println("今天是星期二");
                break;
            default:
                System.out.println("啥也不是！");
                break;
        }
    }
}
