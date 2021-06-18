package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 17:33
 */
public class ObjectCompare {
    public static void main(String[] args) {
        String stra = new String("你好");
        String strb = new String("你好");
        String strc = stra;

        boolean a = stra == strb;
        boolean b = stra == strc;

        boolean c = stra.equals(strb);
        boolean d = stra.equals(strc);

        System.out.println("使用 ”==“ 进行比较的结果：");
        System.out.println("stra 和 strb 进行比较：" + a + "\n" + "stra 和 strc 进行比较：" + b + "\n");

        System.out.println("使用 ”equals“ 进行比较的结果：");
        System.out.println("stra 和 strb 进行比较：" + c + "\n" + "stra 和 strc 进行比较：" + d + "\n");
    }
}
