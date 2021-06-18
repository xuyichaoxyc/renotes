package chapter08_polymorphic.override;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:45
 */
public class Fruit {
    void print(){
        System.out.println("这是父类的方法......");
    }
}

class Apple extends Fruit{
    @Override
    void print(){
        System.out.println("这是子类的方法.......");
    }
}
