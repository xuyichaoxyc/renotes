package chapter04_String;

/**
 * @author ：xuyichao
 * @description：字符串分割
 * @date ：2021/6/17 12:33
 */
public class StringSplitTest {
    public static void main(String[] args) {
        String str = "I am , emmm, used to , learn split method.";

        String[] strArr = str.split(",");
        System.out.println("原句：" + str);

        System.out.println("切割后：");
        for(int i = 0; i < strArr.length; i++){
            System.out.println(strArr[i]);
        }
    }
}
