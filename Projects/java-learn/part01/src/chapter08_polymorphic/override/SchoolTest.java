package chapter08_polymorphic.override;

/**
 * @author ：xuyichao
 * @description：override Test
 * @date ：2021/6/17 19:48
 */
public class SchoolTest {
    public static void main(String[] args) {
        School1 s1 = new School1("xx附中", 10080, 1000, "yy区");
        s1.print();
    }
}

class School{
    String sname;
    int sid;
    int snumber;

    public School(String name, int id, int number){
        this.sname = name;
        this.sid = id;
        this.snumber = number;
    }

    void print(){
        System.out.println("学校名：" + sname + ". 序号：" + sid + ", 人数：" + snumber);
    }
}

class School1 extends School{
    String address;

    public School1(String name, int id, int num, String add){
        super(name, id, num);
        this.address = add;
    }

    @Override
    void print() {
        System.out.println("学校名：" + sname + ". 序号：" + sid + ", 人数：" + snumber + "，地址：" + address);
    }
}
