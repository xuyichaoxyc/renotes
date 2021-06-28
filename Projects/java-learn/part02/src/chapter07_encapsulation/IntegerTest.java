package chapter07_encapsulation;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/28 10:14
 */
public class IntegerTest {
    public static void main(String[] args) {
        System.out.println("Integer 的最大值为：" + Integer.MAX_VALUE);
        System.out.println("Integer 的最小值为：" + Integer.MIN_VALUE);

        String s = new String("1010");
        System.out.println("s 的十进制数是：" + Integer.getInteger(s, 2));

        Integer i = new Integer("1234");
        System.out.println("i 的比较：" + i.compareTo(123));
        int j = 12345;
        System.out.println("转换字符串结果为：" + Integer.toString(j, 16));
    }
}
