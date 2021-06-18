package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 17:18
 */
public class TestCup {
    public static void main(String[] args) {
        CupTest ct = new CupTest();
        ct.high = 15;
        ct.color = "红色";
        ct.price = 10.0;
        System.out.println("一个价格为" + ct.price + "元，高为" + ct.high + "厘米的" + ct.color + "杯子");
        ct.water();
    }
}
