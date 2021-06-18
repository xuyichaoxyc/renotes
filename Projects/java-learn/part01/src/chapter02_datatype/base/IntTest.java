package chapter02_datatype.base;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/16 17:13
 */
public class IntTest {
    public static void main(String[] args) {
        // byte：一个字节
        byte b;
        // short：两个字节
        short s;
        // int：四个字节
        int i;
        // long：八个字节
        long l;

        // 为各类型变量赋值
        b = 12;
        s = 1;
        i = 2;
        l = 1000;

        // 打印输出各类型变量
        System.out.println("byte 类型变量 b 的值为：" + b);
        System.out.println("short 类型变量 s 的值为：" + s);
        System.out.println("int 类型变量 i 的值为：" + i);
        System.out.println("long 类型变量 l 的值为：" + l);
    }
}
