package chapter07_extends.p_final;

/**
 * @author ：xuyichao
 * @description：final 修饰变量，常量
 * final 修饰成员变量，该成员变量就变成常量
 * final 修饰类，该类无法被继承
 * final 修饰方法，该方法不能被重写
 * @date ：2021/6/17 19:12
 */
public class Constant {
    public static void main(String[] args) {
        ConstantTest ct = new ConstantTest();
        System.out.println("a 的值为：" + ct.print());
    }
}

class ConstantTest{
    int print(){
        final int a = 10;
        return a;
    }
}