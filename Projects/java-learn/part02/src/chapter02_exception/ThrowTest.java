package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/22 20:19
 */
public class ThrowTest {
    public void throwException() throws Exception
    {
        String s = null;
        if(s == null)
        {
            throw new Exception("s 的值为 null");
        }
    }

    public static void main(String[] args) {
        ThrowTest tt = new ThrowTest();
        try{
            tt.throwException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
