package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/23 11:02
 */
public class TestMyException {
    public static void main(String[] args) {
        MyException mec = new MyException("自定义异常");
        System.out.println(mec.getMessage());
        System.out.println(mec.toString());
    }
}
