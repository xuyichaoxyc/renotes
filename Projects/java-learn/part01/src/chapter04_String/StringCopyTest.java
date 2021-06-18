package chapter04_String;

/**
 * @author ：xuyichao
 * @description：字符串复制
 * @date ：2021/6/17 12:24
 */
public class StringCopyTest {
    public static void main(String[] args) {
        String str = "Hello World!";

        char[] ch = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            ch[i] = str.charAt(i);
        }

        String strA = String.copyValueOf(ch);
        String strB = String.copyValueOf(ch, 2, 3);

        System.out.println(strA);
        System.out.println(strB);
    }
}
