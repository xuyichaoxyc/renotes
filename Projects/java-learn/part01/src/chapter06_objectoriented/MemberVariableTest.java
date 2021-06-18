package chapter06_objectoriented;

/**
 * @author ：xuyichao
 * @description：成员变量
 * @date ：2021/6/17 15:42
 */
public class MemberVariableTest {
    /**
     * static
     * private、public、protected、default
     * final
     *
     */
    static int i;
    private static int sum;
    int j;
    final int k = 10;

    public void sum(){
        sum = 0;
        for(j = 1; j < 11; j++){
            sum = sum + j;
        }
        System.out.println("从 1 到 10 累计相加结果是：" + sum);
        System.out.println("常量 k 的值为：" + k);
    }

    public static void main(String[] args) {
        sum = 0;
        for(i = 1; i < 11; i++){
            sum += i;
        }
        System.out.println("从 1 到 10 累计相加结果是：" + sum);

        MemberVariableTest var = new MemberVariableTest();
        var.sum();
    }
}
