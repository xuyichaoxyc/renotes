package chapter02_datatype.operator_expression;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 9:51
 */
public class LogicOperatiorTest {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        System.out.println("x & y 的值为：" + (x & y));
        System.out.println("x | y 的值为：" + (x | y));
        System.out.println("!x 的值为：" + !x);
        System.out.println("x && y 的值为：" + (x && y));
        System.out.println("x || y 的值为：" + (x || y));
        System.out.println("x ^ y 的值为：" + (x ^ y));
        System.out.println("x ^ x 的值为：" + (x ^ x));

        /**
         * 异或
         * 相异为 true
         * 相同为 false
         */
        System.out.println("true ^ true ：" + (true ^ true));
        System.out.println("false ^ false ：" + (false ^ false));
        System.out.println("true ^ false ：" + (true ^ false));
        System.out.println("false ^ true ：" + (false ^ true));

    }
}
