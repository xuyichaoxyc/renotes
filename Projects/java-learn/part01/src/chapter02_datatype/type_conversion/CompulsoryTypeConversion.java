package chapter02_datatype.type_conversion;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/16 17:28
 */
public class CompulsoryTypeConversion {
    public static void main(String[] args) {
        int i = 111;
        byte b = (byte)i;
        System.out.println("int 类型强制转换成 byte 类型后的值为：" + b);
        double d = 111.222;
        int j = (int)d;
        System.out.println("double 类型强制转换成 int 类型后的值为：" + j);
    }
}
