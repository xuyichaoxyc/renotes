package chapter07_extends.interfaces;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 19:02
 */
public class SonTest extends FatherTest implements StepFather{

    @Override
    public void hitChild() {
        System.out.println("这是继父");
    }

    public static void main(String[] args) {
        SonTest son = new SonTest();
        son.pet("这是生父");
        son.hitChild();
    }
}

class FatherTest{
    public void pet(String str){
        System.out.println(str);
    }
}

interface StepFather{
    public void hitChild();
}

