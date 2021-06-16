package chapter02_datatype.type_conversion;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/16 17:21
 */
public class ImplicitTypeConversion {
    public static void main(String[] args) {
        // 声明各个类型变量并赋初值,其中 Boolean 类型无法进行转换
        byte b = 1;
        short s = 2;
        char c = 'c';
        int i = 3;
        long l = 4;
        float f = 5;
        double d = 6.0;
        System.out.println("byte 类型变量 b 值为：" + b);
        System.out.println("short 类型变量 s 值为：" + s);
        System.out.println("char 类型变量 c 值为：" + c);
        System.out.println("int 类型变量 i 值为：" + i);
        System.out.println("long 类型变量 l 值为：" + l);
        System.out.println("float 类型变量 f 值为：" + f);
        System.out.println("double 类型变量 d 值为：" + d);

        // 分别将各个类型进行转换
        s = b;
        i = c;
        i = s;
        l = i;
        f = l;
        d = f;
        d = b;
        d = f + d;

        System.out.println("转换后变量 b 值为：" + b);
        System.out.println("转换后变量 s 值为：" + s);
        System.out.println("转换后变量 c 值为：" + c);
        System.out.println("转换后变量 i 值为：" + i);
        System.out.println("转换后变量 l 值为：" + l);
        System.out.println("转换后变量 f 值为：" + f);
        System.out.println("转换后变量 d 值为：" + d);

    }
}
