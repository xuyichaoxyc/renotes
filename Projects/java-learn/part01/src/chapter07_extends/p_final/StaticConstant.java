package chapter07_extends.p_final;

/**
 * @author ：xuyichao
 * @description：final 修饰静态成员变量
 * 该静态成员变量的赋值不得迟于最后一个静态语句块的完成
 * @date ：2021/6/17 19:15
 */
public class StaticConstant {
    public static void main(String[] args) {
        StaticConstantTest sc = new StaticConstantTest();
        System.out.println(sc.eat());
    }
}
class StaticConstantTest{
    static final String str = "去吃饭......";

    static String eat(){
        return str;
    }
}