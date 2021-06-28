package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：向上级调用传递异常
 * @date ：2021/6/22 20:25
 */
public class ExceptionStackTest {
    public static void main(String[] args) throws Exception {
        ExceptionStackTest est = new ExceptionStackTest();
        est.wrapThrowException();
        est.throwException();
    }
    public void topThrowException() throws Exception{
        wrapThrowException();
    }
    public void wrapThrowException() throws Exception{
        throwException();
    }
    public void throwException() throws Exception{
        throw new Exception();
    }
}
