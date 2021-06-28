package chapter04_reflection;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 11:26
 */
class Father{
    // 父类的公共成员变量
    public int memberFather;
    // 父类中的公共方法
    public void methodFather(){
        System.out.println("这是从父类中继承而来的方法 methodFather!");
    }
}

class Son extends Father{
    // 子类的公共成员变量
    public int memberSonPublic;
    // 子类的私有成员变量
    private int memberSonPrivate;

    // 子类的公共方法
    public void methodSonPublic(){
        System.out.println("这是子类自己的方法 methodSonPublic!");
    }
    //
    public void methodSonProtected(){
        System.out.println("这是子类自己的方法 methodSonProtected！");
    }
}
public class ClassTest extends Father{
    public static void main(String[] args) {
        try {
            // 加载指定的类
            Class cs = Class.forName("chapter04_reflection.Son");
            Son mySon = (Son)cs.newInstance();

            // 调用创建对象的方法
            System.out.println("调用创建对象的方法：");
            mySon.methodSonProtected();
            mySon.methodSonPublic();
            mySon.methodFather();

            // 加载类的详细信息
            System.out.println("加载类的信息：");
            System.out.println(cs.getName() + "自己声明了" + cs.getDeclaredFields().length + "成员变量。");
            System.out.println(cs.getName() + "类对外公布的方法有" + cs.getMethods().length + "个");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

