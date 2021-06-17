package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 15:28
 */
public class PeopleMain {
    private String name;
    private String sex;
    private int age;

    public String eat(String food){
//        System.out.println("我在吃" + food);
        return "我在吃" + food;
    }

    public void tea(){
        System.out.println("我在喝茶");
    }

    public static void main(String[] args) {
        String str = new PeopleMain().eat("Apple");
        System.out.println(str);
        new PeopleMain().tea();
    }
}
