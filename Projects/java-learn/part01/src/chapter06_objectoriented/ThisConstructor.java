package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 16:00
 */
public class ThisConstructor {
    String name;

    public ThisConstructor(String name)
    {
        this.name = name;
        System.out.println("姓名：" + name);
    }

    public ThisConstructor(){
        this("张三");
    }

    public static void main(String[] args) {
        new ThisConstructor();
    }
}
