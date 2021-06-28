package chapter06_regular;

/**
 * @author ：xuyichao
 * @description：字符串分割操作
 * @date ：2021/6/28 10:06
 */
public class SplitTest {
    public static void main(String[] args) {
        // 创建字符串表示的正则表达式和被匹配的字符串
        String patterStr = ";|,";
        String str = "张三;李四,王五";

        System.out.println("需要拆分的内容是：");
        System.out.println(str);

        System.out.println("将字符串按照默认分割：");
        String[] attStr = str.split(patterStr);
        for (int i = 0; i < attStr.length; i++) {
            System.out.println("attStr[" + i + "] = <" + attStr[i] + ">");
        }

        System.out.println("\n将字符串拆分成三份：");
        attStr = str.split(patterStr, 3);
        for (int i = 0; i < attStr.length; i++) {
            System.out.println("attStr[" + i + "] = <" + attStr[i] + ">");
        }

        System.out.println("\n将字符串拆分成-2份：");
        attStr = str.split(patterStr, -2);
        for (int i = 0; i < attStr.length; i++) {
            System.out.println("attStr[" + i + "] = <" + attStr[i] + ">");
        }

        System.out.println("\n将字符串拆分成0份：");
        attStr = str.split(patterStr, 0);
        for (int i = 0; i < attStr.length; i++) {
            System.out.println("attStr[" + i + "] = <" + attStr[i] + ">");
        }
    }
}
