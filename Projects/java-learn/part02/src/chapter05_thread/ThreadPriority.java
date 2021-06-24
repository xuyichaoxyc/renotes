package chapter05_thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xuyichao
 * @description：测试线程优先级
 * @date ：2021/6/24 8:33
 */
public class ThreadPriority {
    public static void main(String[] args) {
        List list = new ArrayList();
        Student st1 = new Student("张三", 5, 98, 130);
        list.add(st1);
        Student st2 = new Student("李四", 3, 95, 150);
        list.add(st2);
        Student st3 = new Student("王五", 4, 100, 120);
        list.add(st3);
        Student st4 = new Student("赵六", 6, 91, 140);
        list.add(st4);
        Student st5 = new Student("钱七", 7, 93, 150);
        list.add(st5);

        System.out.println("按成绩分数的高低排坐");
        new Score().RowSeat(list);
        System.out.println("按身高的大小排坐");
        new Height().RowSeat(list);
    }
}

// 学生类
class Student {
    // 姓名
    public String name;
    // 年龄
    public int age;
    // 成绩
    public int score;
    // 身高
    public int height;

    // 构造函数为各成员变量赋值
    public Student(String name, int age, int score, int height) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.height = height;
    }
}

class Height implements Runnable{
    Thread thread;
    Height(){

    }

    Height(String name){
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        // 获取线程名称
        System.out.println("一年一班的学生成员：" + thread.getName());
    }

    // 按照线程优先级执行线程
    public void RowSeat(List list){
        Student st = (Student) list.get(0);
        Student st1 = (Student) list.get(1);
        Student st2 = (Student) list.get(2);
        Student st3 = (Student) list.get(3);
        Student st4 = (Student) list.get(4);

        // 创建线程对象并命名
        Height o1 = new Height(st.name);
        Height o2 = new Height(st1.name);
        Height o3 = new Height(st2.name);
        Height o4 = new Height(st3.name);
        Height o5 = new Height(st4.name);

        // 较次之，NORM_PRIORITY 优先级中间，5
        o1.thread.setPriority(Thread.NORM_PRIORITY - 1);
        // MAX_PRIORITY 优先级最大，10
        o2.thread.setPriority(Thread.MAX_PRIORITY);
        // MIN_PRIORITY 优先级最小，1
        o3.thread.setPriority(Thread.MIN_PRIORITY);
        // 中间优先级
        o4.thread.setPriority(Thread.NORM_PRIORITY);
        //
        o5.thread.setPriority(Thread.MAX_PRIORITY - 1);

        o1.thread.start();
        o2.thread.start();
        o3.thread.start();
        o4.thread.start();
        o5.thread.start();

        try {
            o5.thread.join();
        } catch (InterruptedException e) {
            System.out.println("等待线程结束出错：" + e.getMessage());
        }
    }

}

class Score extends Thread{
    Thread thread;
    Score(){

    }

    Score(String name){
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        // 获取线程名称
        System.out.println("一年一班的学生成员：" + thread.getName());
    }

    // 按照线程优先级执行线程
    public void RowSeat(List list){
        Student st = (Student) list.get(0);
        Student st1 = (Student) list.get(1);
        Student st2 = (Student) list.get(2);
        Student st3 = (Student) list.get(3);
        Student st4 = (Student) list.get(4);

        // 创建线程对象并命名
        Score o1 = new Score(st.name);
        Score o2 = new Score(st1.name);
        Score o3 = new Score(st2.name);
        Score o4 = new Score(st3.name);
        Score o5 = new Score(st4.name);

        // 设置优先级，10最高，1最小
        o1.thread.setPriority(st.score / 10);
        o2.thread.setPriority(st1.score / 10);
        o3.thread.setPriority(st2.score / 10);
        o4.thread.setPriority(st3.score / 10);
        o5.thread.setPriority(st4.score / 10);

        o1.thread.start();
        o2.thread.start();
        o3.thread.start();
        o4.thread.start();
        o5.thread.start();

        try {
            o5.thread.join();
        } catch (InterruptedException e) {
            System.out.println("等待线程结束出错：" + e.getMessage());
        }
    }

}