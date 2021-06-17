package chapter05_controlstatement;

/**
 * @author ：xuyichao
 * @description：条件语句
 * @date ：2021/6/17 14:37
 */
public class ConditionalStatementTest {
    public static void main(String[] args) {
        /**
         * if(布尔表达式){
         *     statement
         * }
         *     statement
         */
        int zage = 22;
        int lage = 23;
        if(zage > lage){
            System.out.println("张三年龄为：" + zage);
            System.out.println("李四年龄为：" + lage);
            System.out.println("张三比李四大！");
        }
        if(lage > zage){
            System.out.println("张三年龄为：" + zage);
            System.out.println("李四年龄为：" + lage);
            System.out.println("张三比李四小！");
        }


        /**
         * if(布尔表达式){
         *     statement
         * }
         * else{
         *     statement
         * }
         */

        int zs = 90;
        int ls = 95;
        if(zs > ls){
            System.out.println("张三赢了");
        }
        else{
            System.out.println("李四赢了");
        }


        /**
         * if(布尔表达式1){
         *     statement1
         * }
         * else if(布尔表达式2){
         *     statement2
         * }
         * else if(布尔表达式3){
         *     statement3
         * }
         * else{
         *     statement4
         * }
         */

        int i = 88;
        if(i > 90){
            System.out.println("i 值为：" + i + "，非常大");
        }
        else if(i > 80){
            System.out.println("i 值为：" + i + "，较大");
        }
        else{
            System.out.println("i 值为：" + i + "，有点小");
        }

    }
}
