package chapter02_datatype.operator_expression;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 10:04
 */
public class BitOperatorTest {
    public static void main(String[] args) {
        // 位右移 >>
        System.out.println("00001111 >> 2 运算结果：" + (00001111 >> 2));
        // 位左移 <<
        System.out.println("11000011 << 2 运算结果：" + (11000011 << 2));
        // 无符号位右移 >>>
        System.out.println("11110000 >>> 2 运算结果：" + (11110000 >>> 2));
        // 按位与 &
        System.out.println("00001111 & 00001110 运算结果：" + (00001111 & 00001110));
        // 按位或
        System.out.println("00001111 | 00001110 运算结果：" + (00001111 | 00001110));
        // 按位异或
        System.out.println("00001111 ^ 00001110 运算结果：" + (00001111 ^ 00001110));
        // 按位取反
        System.out.println("~ 00001111 运算结果：" + (~ 00001111));


        // 位右移 >>
        System.out.println("00001111 >> 2 运算结果：" + Integer.toBinaryString(00001111 >> 2));
        // 位左移 <<
        System.out.println("11000011 << 2 运算结果：" + Integer.toBinaryString(11000011 << 2));
        // 无符号位右移 >>>
        System.out.println("11110000 >>> 2 运算结果：" + Integer.toBinaryString(11110000 >>> 2));
        // 按位与 &
        System.out.println("00001111 & 00001110 运算结果：" + Integer.toBinaryString(00001111 & 00001110));
        // 按位或
        System.out.println("00001111 | 00001110 运算结果：" + Integer.toBinaryString(00001111 | 00001110));
        // 按位异或
        System.out.println("00001111 ^ 00001110 运算结果：" + Integer.toBinaryString(00001111 ^ 00001110));
        // 按位取反
        System.out.println("~ 00001111 运算结果：" + Integer.toBinaryString(~ 00001111));

    }
}
