package chapter05_thread;

/**
 * @author ：xuyichao
 * @description：线程同步
 * @date ：2021/6/24 9:49
 */

class Printer{
    // 打印方法
    // synchronized void printScore(String name, int score1, int score2, int score3) {
    void printScore(String name, int score1, int score2, int score3) {
        System.out.println(name + " 的成绩：");
        System.out.println(name + " 英语：");
        System.out.println(score1);
        // 使程序运行结果明显，在打印过程中，使线程休眠
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 数学：");
        System.out.println(score2);
        System.out.println(name + " 语文：");
        System.out.println(score3);
    }
}

// 教师类，每个教师都有自己的线程并且公用一个打印机
class Teacher implements Runnable{

    Printer ps = null;
    String name = null;
    Thread t;
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;

    public Teacher(Printer ps, String name, int score1, int score2, int score3) {
        this.ps = ps;
        this.name = name;
        this.t = new Thread(this, name);
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    // 教师调用打印机
    @Override
    public void run() {
//        ps.printScore(name, score1, score2, score3);
        synchronized (ps) {
            ps.printScore(name, score1, score2, score3);
        }
    }

}
public class SyncDemo {
    public static void main(String[] args) {
        // 创建一个打印机对象
        Printer ps = new Printer();

        // 创建 3 个教师实例
        Teacher t1 = new Teacher(ps, "张三", 87, 76, 90);
        Teacher t2 = new Teacher(ps, "李四", 97, 86, 70);
        Teacher t3 = new Teacher(ps, "王五", 67, 86, 97);

        // 启动打印机工作
        t1.t.start();
        t2.t.start();
        t3.t.start();
    }
}
