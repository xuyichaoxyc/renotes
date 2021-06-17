package chapter04_String;

/**
 * @author ：xuyichao
 * @description：字符串比较
 * @date ：2021/6/17 12:14
 */
public class StringCompareTest {
    public static void main(String[] args) {
        String zhangsan = "Think In Java";
        String lisi = "Think In Java";
        String wangwu = "think in java";
        String zhaoliu = "Think in Java";

        if(zhangsan.equals(lisi)){
            System.out.println("张三和李四读书内容相同");
        }
        else{
            System.out.println("张三和李四读书内容不同");
        }

        if(zhangsan.equals(wangwu)){
            System.out.println("张三和王五读书内容相同");
        }
        else{
            System.out.println("张三和王五读书内容不同");
        }

        if(zhangsan.equalsIgnoreCase(zhaoliu)){
            System.out.println("张三和赵六读书内容相同");
        }
        else{
            System.out.println("张三和赵六读书内容不同");
        }

        if(zhangsan.compareTo(zhaoliu) > 0){
            System.out.println("张三和赵六读书内容相同");
        }
        else{
            System.out.println("张三和赵六读书内容不同");
        }

        System.out.println(zhangsan.compareTo(zhaoliu));
        System.out.println("a".compareTo("b"));
        System.out.println("a".compareTo("a"));
        System.out.println("b".compareTo("a"));
    }
}
