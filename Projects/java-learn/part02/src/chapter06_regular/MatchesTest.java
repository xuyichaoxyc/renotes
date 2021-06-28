package chapter06_regular;

/**
 * @author ：xuyichao
 * @description：String 的 mtches 方法测试
 * 只能整体匹配，不能局部匹配
 * @date ：2021/6/28 9:54
 */
public class MatchesTest {
    public static void main(String[] args) {
        String patterStr = "\\d{4}-\\d{2}-\\d{2}";
        String str1 = "6666-23-90";
        String str2 = "内容是：6666-23-90";

        if (str1.matches(patterStr)) {
            System.out.println("str1 内容匹配成功");
        } else {
            System.out.println("str1 内容匹配失败");
        }

        if (str2.matches(patterStr)) {
            System.out.println("str2 内容匹配成功");
        } else {
            System.out.println("str2 内容匹配失败");
        }
    }
}
