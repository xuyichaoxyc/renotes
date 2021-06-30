package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：空指针异常示例
 * @date ：2021/6/22 20:05
 */
public class NullPointerExceptionTest {
    public static void main(String[] args) {
        ClassTest ct = null;
        ct.getName();
    }
}

class ClassTest{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }
}
