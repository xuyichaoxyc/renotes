package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 15:57
 */
public class ThisTest {
    int i = 16;
    String eat = "吃饭时间";
    String tea = "下午茶时间";
    public void eat(int i){
        if(i > 11 && i < 14){
            System.out.println("现在时间是" + i + "点，是" + eat);
        }
        else if(i > 15 && i < 17){
            System.out.println("现在时间是" + i + "点，是" + tea);
        }
    }

    public void tea(int i){
        if(this.i > 11 && this.i < 14){
            System.out.println("现在时间是" + this.i + "点，是" + eat);
        }
        else if(this.i > 15 && this.i < 17){
            System.out.println("现在时间是" + this.i + "点，是" + tea);
        }
    }

    public static void main(String[] args) {
        ThisTest tt = new ThisTest();
        tt.eat(12);
        tt.tea(12);

    }
}
