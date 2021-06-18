package chapter07_extends.exercise;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:33
 */
public class Employee extends Person {
    public Employee(String id) {
        super(id);
    }

    @Override
    public String speak() {
        return "I am a employee!";
    }

    @Override
    public String move() {
        return "I go to work by subway!";
    }

    public String work(){
        return "I hava to work for money!";
    }

}
