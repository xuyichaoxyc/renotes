package chapter04_String;

/**
 * @author ：xuyichao
 * @description：字符串连接
 * @date ：2021/6/17 12:21
 */
public class StringConcatTest {
    public static void main(String[] args) {
        String strA = "Hello ";
        String strB = "World";
        String strC = "!";

        String concatA = strA.concat(strB);
        String concatB = concatA.concat(strC);

        String concat = strA + strB + strC;

        System.out.println(concatA);
        System.out.println(concatB);
        System.out.println(concat);
    }
}
