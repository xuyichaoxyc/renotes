package chapter02_datatype.operator_expression;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 9:28
 */
public class IDOperatorTest {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = a++;
        int d = ++b;
        System.out.println("a 值为：" + a);
        System.out.println("b 值为：" + b);
        System.out.println("c 值为：" + c);
        System.out.println("d 值为：" + d);


        int e = 5;
        int f = 5;
        int g = e--;
        int h = --f;
        System.out.println("e 值为：" + e);
        System.out.println("f 值为：" + f);
        System.out.println("g 值为：" + g);
        System.out.println("h 值为：" + h);
    }
}
