package chapter07_encapsulation;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/28 10:19
 */
public class DoubleTest {
    public static void main(String[] args) {
        Double dd = new Double(56);

        System.out.println("Double 最大值为：" + dd.MAX_VALUE);
        System.out.println("Double 最小值为：" + dd.MIN_VALUE);

        System.out.println("Double 类型为：" + dd.TYPE);
        System.out.println("Double 的数据大小为；" + dd.SIZE);
        System.out.println("Double 的正无穷：" + dd.POSITIVE_INFINITY);
        System.out.println("Double 的负无穷：" + dd.NEGATIVE_INFINITY);
    }
}
