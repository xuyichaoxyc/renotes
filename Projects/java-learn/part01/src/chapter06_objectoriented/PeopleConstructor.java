package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 15:31
 */
public class PeopleConstructor {
    private String name;
    private String sex;
    private int age;

    public PeopleConstructor(){

    }

    public String eat(String food){
//        System.out.println("我在吃" + food);
        return "我在吃" + food;
    }

    public void tea(){
        System.out.println("我在喝茶");
    }

    public static void main(String[] args) {
        PeopleConstructor peoplec = new PeopleConstructor();
        System.out.println("name 初始值：" + peoplec.name);
        System.out.println("sex 初始值：" + peoplec.sex);
        System.out.println("age 初始值：" + peoplec.age);
    }
}
