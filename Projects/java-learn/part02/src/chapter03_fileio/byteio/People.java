package chapter03_fileio.byteio;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/21 23:13
 * @description：People类，用以字节输入输出流
 * @modified By：
 * @version: 1.0.0$
 */
public class People {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }
}
