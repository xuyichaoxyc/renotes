package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 10:57
 */
public class MyException extends Exception{
    // 构造函数
    MyException(){

    }

    // 待参数的构造函数
    MyException(String msg){
        // 调用父类方法
        super(msg);
    }


}
