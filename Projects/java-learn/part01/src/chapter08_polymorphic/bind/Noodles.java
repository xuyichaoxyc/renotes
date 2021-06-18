package chapter08_polymorphic.bind;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/18 9:00
 */
public class Noodles extends Food{
    public void taste(){
        System.out.println("It's delicious!");
    }

    public void smell(){
        System.out.println("Smell Sweet");
    }

    public void feed(){
        System.out.println("It's nutritious");
    }

    public static void main(String[] args) {
        Food food = new Noodles();
        food.taste();
        food.smell();
        food.feed();
    }
}
