package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 17:31
 */
public class PeopelTest {
    public static void main(String[] args) {
        People people = new People();
        System.out.println("个人信息输出：");
        System.out.println("姓名：" + people.name);
        System.out.println("性别：" + people.sex);
        System.out.println("年龄：" + people.age);
        System.out.println("地址：" + people.address);
        System.out.println(people.name + "do what？");
        System.out.println(people.name + people.eat());
    }
}
