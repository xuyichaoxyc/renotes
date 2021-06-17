package chapter07_extends.AbstractClass;

/**
 * @author ：xuyichao
 * @description：继承抽象类
 * @date ：2021/6/17 19:06
 */

/**
 * 抽象类特点：
 * 1. 至少含有一个抽象方法
 * 2. 不能被实例化
 * 3. 继承抽象类的子类必须实现其所有抽象方法才能够被实例化，否则该子类还是抽象类
 */
public class SubClass extends AbstractClass{

    @Override
    public void speak() {
        System.out.println("我请大家去吃饭......");
    }

    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.speak();
        sc.eat();
    }
}

abstract class AbstractClass{
    public void eat(){
        System.out.println("我们一起去吃饭......");
    }

    public abstract void speak();
}