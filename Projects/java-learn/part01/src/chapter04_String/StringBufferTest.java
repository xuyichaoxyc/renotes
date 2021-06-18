package chapter04_String;

/**
 * @author ：xuyichao
 * @description：StringBuffer,线程安全，可变
 * @date ：2021/6/17 12:37
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("张三，");
        sb.append("回家，");
        sb.append("吃饭！");

        System.out.println(sb.toString());

        System.out.println("sb 的长度为：" + sb.length());
        System.out.println(sb.indexOf("回"));
        sb.insert(3, "不要");
        System.out.println(sb.toString());
    }
}
