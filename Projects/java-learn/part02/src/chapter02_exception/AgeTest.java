package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 11:10
 */
public class AgeTest {
    static String ageLevel(int age) throws IllegalAgeException{
        if(age >= 10 && age < 18){
            return "小孩";
        }
        else if (age >= 18 && age < 30){
            return "小伙子";
        }
        else if (age >= 30 && age < 40){
            return "中年人";
        }
        else if (age >= 40 && age < 100){
            return "老年人";
        }
        else
        {
            throw new IllegalAgeException("非法的年龄");
        }
    }

    public static void main(String[] args) {
        try{
            String name = "zhangsan";
            String name2 = "lisi";
            String level = null;

            level = ageLevel(20);
            System.out.println(name + " 是：" + level);
            level = ageLevel(140);
            System.out.println(name2 + " 是：" + level);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
    }
}

class IllegalAgeException extends Exception{
    IllegalAgeException(){

    }

    IllegalAgeException(String msg){
        super(msg);
    }
}
