package chapter07_extends;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:25
 */
public class ToStringTest {
    public static void main(String[] args) {
        ToString ts = new ToString();
        ts.setName("张三");
        ts.setAge(32);
        ts.setSex("男");
        System.out.println(ts);
    }
}
