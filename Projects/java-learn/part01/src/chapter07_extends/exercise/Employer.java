package chapter07_extends.exercise;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:35
 */
public class Employer extends Person implements Manager{
    public Employer(String id) {
        super(id);
    }


    @Override
    public String speak() {
        return "I am boss!";
    }

    @Override
    public String move() {
        return "I drive a car";
    }

    @Override
    public String manage(Employee employee) {
        if(employee.fly()){
            return "You can fly, i will give you much money!";
        }
        else
        {
            return "Oops, you can not fly.";
        }
    }
}
