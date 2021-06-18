package chapter08_polymorphic.bind;

/**
 * @author ：xuyichao
 * @description：静态绑定
 * @date ：2021/6/18 8:52
 */
public class Auto {
    public String name = "an automobile";
    public void engine(){
        System.out.println("a poor engine");
    }

    public final void price(){
        System.out.println("This is a budget machine. ");

    }

    public static void run(){
        System.out.println("a bit slow");

    }

    public void fun(){
        System.out.println("Driving fun");

    }


}
