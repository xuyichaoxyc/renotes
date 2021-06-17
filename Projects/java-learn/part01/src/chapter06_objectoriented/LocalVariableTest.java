package chapter06_objectoriented;

import java.util.logging.Logger;

/**
 * @author ：xuyichao
 * @description：局部变量
 * @date ：2021/6/17 15:48
 */
public class LocalVariableTest {
    public void eat(){
        int i = 12;
        String eat = "吃饭时间";
        String tea = "下午茶时间";
        if(i > 11 && i < 14){
            System.out.println("现在时间是" + i + "点，是" + eat);
        }
        else if(i > 15 && i < 17){
            System.out.println("现在时间是" + i + "点，是" + tea);
        }
    }

    public void tea(){
        int i = 16;
        String eat = "吃饭时间";
        String tea = "下午茶时间";
        if(i > 11 && i < 14){
            System.out.println("现在时间是" + i + "点，是" + eat);
        }
        else if(i > 15 && i < 17){
            System.out.println("现在时间是" + i + "点，是" + tea);
        }
    }

    public static void main(String[] args) {
        LocalVariableTest lv = new LocalVariableTest();
        lv.eat();
        lv.tea();
    }
}
