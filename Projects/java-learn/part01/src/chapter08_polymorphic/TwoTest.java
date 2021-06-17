package chapter08_polymorphic;

/**
 * @author ：xuyichao
 * @description：覆写和重载的结合
 * @date ：2021/6/17 19:58
 */
public class TwoTest {
    public static void main(String[] args) {
        TestTwo tt = new TestTwo();
        tt.a = 5;
        tt.b = 6;
        tt.sub();
        tt.add();
        tt.sub(3);
    }
}

class Test{
    int a;
    int b;
    int add(){
        System.out.println("a 加 b 值：" + (a + b));
        return a + b;
    }
    int sub(){
        System.out.println("a 减 b 值：" + (a - b));
        return a - b;
    }
}

class TestTwo extends Test{
    int add(){
        System.out.println("a 的值：" + a);
        return a;
    }
    int sub(){
        System.out.println("b 的值：" + b);
        return b;
    }
    int sub(int c){
        System.out.println(a - c);
        return a - c;
    }
}