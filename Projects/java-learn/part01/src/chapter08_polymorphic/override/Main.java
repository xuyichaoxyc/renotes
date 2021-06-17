package chapter08_polymorphic.override;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:46
 */
public class Main {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        fruit.print();

        Apple apple = new Apple();
        apple.print();

        Fruit fruit1 = new Apple();
        fruit1.print();
    }
}
