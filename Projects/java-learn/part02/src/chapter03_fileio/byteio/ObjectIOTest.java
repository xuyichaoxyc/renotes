package chapter03_fileio.byteio;

import java.io.*;
import java.util.Calendar;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/21 23:58
 * @description：字节对象输入输出流，即对象序列化
 * @modified By：
 * @version: 1.0.0$
 */
public class ObjectIOTest {
    public static void serialize(String fileName) throws IOException {
        // 创建一个对象字节输出流，将对象输出到文件
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName)
        );

        // 序列化一个字符串对象到文件
        out.writeObject("今天的日期和事件如下：");
        // 序列化当前日期对象到文件
        out.writeObject(Calendar.getInstance());
        // 序列化一个 MyClass 对象
        TestClass tc = new TestClass(1, 2, 3, 4);
        out.writeObject(tc);
        out.close();
    }

    public static void deserialize(String fileName) throws IOException, ClassNotFoundException {
        // 创建一个对象字节输入流，从文件读取对象
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName)
        );

        // 读取字符串对象
        String today = (String) in.readObject();
        System.out.println(today);
        // 读取日历 Calendar 对象
        Calendar date = (Calendar) in.readObject();
        System.out.println(date.get(Calendar.YEAR) + "年"
                        + (date.get(Calendar.MONTH + 1)) + "月"
                + date.get(Calendar.DAY_OF_MONTH) + "日："
                + date.getTime().toLocaleString()
                );

        // 从输入流中读取 TestClass 对象
        TestClass tc = (TestClass)in.readObject();
        System.out.println(tc);

        in.close();
    }

    public static void main(String[] args) {
        System.out.println("反序列化结果如下：");
        String fileName = "TestClass.txt";
        try {
            ObjectIOTest.serialize(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectIOTest.deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 一个类，用于被序列化和反序列化
 * 一定要实现 Serializable 才能被序列化
 */
class TestClass implements Serializable{
    // 一般的实例变量会被序列化和反序列化
    private int i, n;
    // 用 transient 声明的变量不会被序列化和反序列化
    private transient int x;
    // 类变量也不会被序列化和反序列化
    private static int y;

    public TestClass(int m, int n, int x, int y){
        this.i = m;
        this.n = n;
        this.x = x;
        TestClass.y = y;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "i=" + i +
                ", n=" + n +
                ", x=" + x +
                '}';
    }
}
