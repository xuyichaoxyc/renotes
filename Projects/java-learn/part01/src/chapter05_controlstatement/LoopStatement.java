package chapter05_controlstatement;

/**
 * @author ：xuyichao
 * @description：循环结构
 * @date ：2021/6/17 14:49
 */
public class LoopStatement {
    public static void main(String[] args) {
        /**
         * for 循环：
         * for(表达式1;可返回布尔值的表达式;表达式2){
         *     statement;
         * }
         */
        for(int i = 0; i < 3; i++){
            System.out.println("外层第" + i + "层循环");
            System.out.println("===================");
            for(int j = 0; j < 3; j++){
                System.out.println("内层第" + j + "层循环");
            }
            System.out.println("===================");
        }

        /**
         * while 循环：
         * while(可返回布尔值的表达式){
         *     statement;
         * }
         */

        int i = 0;
        while(i < 5){
            System.out.println("i 还没到：" + i);
            i++;
        }
        System.out.println("i 到了: " + i);


        /**
         * do-while 循环
         * do{
         *     statement;
         * }
         * while(可返回布尔值的表达式);
         */
        int j = 0;
        do {
            System.out.println("j 到了：" + j);
            j++;
        }while(j < 5);
        System.out.println("j 最后到达：" + j);
    }
}
