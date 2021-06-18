package chapter07_extends;

/**
 * @author ：xuyichao
 * @description：Object 类,ToString 重写
 * @date ：2021/6/17 19:20
 */
public class ToString {
    private String name;
    private int age;
    private String sex;

    public ToString(){

    }
    public ToString(String name, int age, String sex){
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ToString{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}