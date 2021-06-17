package chapter04_String;

/**
 * @author ：xuyichao
 * @description：字符串替换
 * @date ：2021/6/17 12:27
 */
public class StringReplaceTest {
    public static void main(String[] args) {
        String str = new String("I am, mam I");
        /**
         * replace：替换字符，所有
         * replaceAll：替换字符串，所有
         * replaceFirst：替换字符串，第一个
         */
        String strA = str.replace('I', 'Y');
        String strB = str.replaceAll("am", "bn");
        String strC = str.replaceFirst("am", "bn");
        System.out.println(str);
        System.out.println(strA);
        System.out.println(strB);
        System.out.println(strC);
    }
}
