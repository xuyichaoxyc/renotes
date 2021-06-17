package chapter07_extends.exercise;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:40
 */
public class Police {
    public static void main(String[] args) {
        Person p1 = new Employee("135");
        Person p2 = new Employee("246");
        Person p3 = new Employee("135");

        if(p1.equals(p2)){
            System.out.println("p1 与 p2 是同一个人！");
        }
        else{
            System.out.println("p1 与 p2 不是同一个人！");
        }
        if(p1.equals(p3)){
            System.out.println("p1 与 p2 是同一个人！");
        }
        else{
            System.out.println("p1 与 p3 不是同一个人！");
        }
    }
}
