package chapter04_String;

import java.io.UnsupportedEncodingException;

/**
 * @author ：xuyichao
 * @description：字符串声明
 * @date ：2021/6/17 12:05
 */
public class StringDeclarationTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /**
         * 常量声明方式
         * String stringName = "string";
         */
        String constantString = "Hello World!";

        /**
         * 对象声明方式
         * String stringName = new String(args)
         */

        /**
         * 字符串创建
         */
        String string1 = new String();
        String string2 = new String("hello");
        String string3 = new String(new char[]{'h', 'e', 'l'});
        String string4 = new String(new char[]{'h', 'e', 'l', 'l', 'o'}, 2, 2);
        // Unicode code point
        String string5 = new String(new int[]{1, 2, 3, 4, 5}, 0, 3);
        // 系统默认字符集节码 byte 数组
        String string6 = new String(new byte[]{3,4,5,6});
        String string7 = new String(new byte[]{1,2,4,5,6,7,8}, 1, 3);
        String string8 = new String(new byte[]{1,2,4,5,6,7,8}, 1, 3, "GBK");
        String string9 = new String(new byte[]{1,2,4,5,6,7,8}, "utf-8");
        String string10 = new String(new StringBuffer("fjiea"));

        System.out.println(constantString);
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);
        System.out.println(string5);
        System.out.println(string6);
        System.out.println(string7);
        System.out.println(string8);
        System.out.println(string9);
        System.out.println(string10);

    }
}
