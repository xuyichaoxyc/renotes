package chapter07_extends.exercise;

/**
 * @author ：xuyichao
 * @description：People 抽象类
 * @date ：2021/6/17 19:31
 */
public abstract class Person {
    public final boolean liveForever = false;
    public final String id;

    protected Person(String id) {
        this.id = id;
    }

    public final boolean fly(){
        return false;
    }

    public abstract String speak();
    public abstract String move();
}
