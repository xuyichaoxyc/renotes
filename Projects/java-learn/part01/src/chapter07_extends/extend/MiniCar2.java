package chapter07_extends.extend;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:00
 */
public class MiniCar2 extends Car{
    private int maxspeed;

    public int getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    public static void main(String[] args) {
        MiniCar2 car = new MiniCar2();
        System.out.println("父类中车的颜色是：" + car.color);
        car.setColor("blue");
        System.out.println("子类中车的颜色是：" + car.color);

        System.out.println("小汽车的最大速度为：");
        car.setMaxspeed(180);
        System.out.println(car.maxspeed);
    }
}
