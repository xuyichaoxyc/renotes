package chapter06_regular;

/**
 * @author ：xuyichao
 * @description：查找替换
 * replaceAll
 * replaceFirst
 * @date ：2021/6/28 9:59
 */
public class ReplaceTest {
    public static void main(String[] args) {
        String patternStr = "\\b\\d*\\.\\d{3,}\\b";
        String s1 = "123.5 123.56 123.5678 123.5600 123.0098";

        // 打印待匹配的初始内容
        System.out.println("初始字符串内容是：");
        System.out.println(s1);

        // 进行 replaceAll 全部匹配替换操作
        String s2 = s1.replaceAll(patternStr, "Error");
        // 打印 全部匹配替换后的操作
        System.out.println("使用 replaceAll 方法后结果为：");
        System.out.println(s2);

        // 进行 replaceFirst 第一个匹配替换操作
        s2 = s1.replaceFirst(patternStr, "Error");
        System.out.println("使用 replaceFirst 方法后结果为：");
        System.out.println(s2);
    }
}
