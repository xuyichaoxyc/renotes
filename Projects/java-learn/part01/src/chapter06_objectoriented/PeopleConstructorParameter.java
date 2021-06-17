package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 15:34
 */
public class PeopleConstructorParameter {

    private String name;
    private String sex;
    private int age;

    public PeopleConstructorParameter(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    public String eat(String food){
//        System.out.println("我在吃" + food);
        return "我在吃" + food;
    }

    public void tea(){
        System.out.println("我在喝茶");
    }

    public static void main(String[] args) {
        PeopleConstructorParameter people = new PeopleConstructorParameter("张三", "男", 10);
        System.out.println("姓名：" + people.name);
        System.out.println("性别：" + people.sex);
        System.out.println("年龄：" + people.age);
    }

}
