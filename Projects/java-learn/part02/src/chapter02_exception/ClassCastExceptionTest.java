package chapter02_exception;

/**
 * @author ：xuyichao
 * @description：运行时异常：
 * 类型转换异常
 * @date ：2021/6/22 19:56
 */
public class ClassCastExceptionTest {
    public static void main(String[] args) {
        Book book = new NovelBook();
        Object o = book;
        String s = (String) o;
        System.out.println(s);
    }
}

class Book{
    private String title;
    private String content;
    private String author;
}

class NovelBook extends Book
{
    private String type = "友谊";

    @Override
    public String toString() {
        return "主题：" + type;
    }
}
