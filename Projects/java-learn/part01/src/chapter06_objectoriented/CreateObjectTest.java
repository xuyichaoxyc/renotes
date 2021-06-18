package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：创建和使用对象
 * @date ：2021/6/17 17:07
 */
public class CreateObjectTest {
    public static void main(String[] args) {
        Cup cup = new Cup();
        System.out.println("对杯子没有要求");
        Cup cup1 = new Cup("红色", 15);
        System.out.println("一个高为15厘米的红色杯子");
        Cup cup2 = new Cup(10.0, 15);
        System.out.println("一个高为15厘米，价格为10元的杯子");
        Cup cup3 = new Cup(10.0, "红色");
        System.out.println("一个10元的红色杯子");
        Cup cup4 = new Cup(10.0, "红色", 15);
        System.out.println("一个价格为10元，高为15厘米的红色杯子");
    }
}
class Cup{
    private int high;
    private String color;
    private double price;

    public Cup(){

    }
    public Cup(String color, int high){
        this.color = color;
        this.high = high;
    }
    public Cup(double price, int high){
        this.price = price;
        this.high = high;
    }
    public Cup(double price, String color){
        this.price = price;
        this.color = color;
    }

    public Cup(double price, String color, int high){
        this.price = price;
        this.color = color;
        this.high = high;
    }
}