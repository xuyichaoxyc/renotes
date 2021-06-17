package chapter06_objectoriented;

import javax.swing.*;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 15:37
 */
public class PeopleMore {
    private String name;
    private String sex;
    private int age;

    public PeopleMore(){

    }

    public PeopleMore(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public PeopleMore(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    public static void main(String[] args) {
        PeopleMore zhangsan = new PeopleMore("张三", "男", 20);
        PeopleMore lisi = new PeopleMore("李四", "女");
        PeopleMore wangwu = new PeopleMore();
        System.out.println("张三具体信息：");
        System.out.println("姓名：" + zhangsan.name);
        System.out.println("性别：" + zhangsan.sex);
        System.out.println("年龄：" + zhangsan.age);

        System.out.println("李四具体信息：");
        System.out.println("姓名：" + lisi.name);
        System.out.println("性别：" + lisi.sex);
        System.out.println("年龄：" + lisi.age);

        System.out.println("wangwu具体信息：");
        System.out.println("姓名：" + wangwu.name);
        System.out.println("性别：" + wangwu.sex);
        System.out.println("年龄：" + wangwu.age);
    }
}
