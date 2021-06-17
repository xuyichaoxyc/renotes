package chapter03_Array;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/17 10:32
 */
public class ArrayDefaultTest {
    public static void main(String[] args) {
        byte[] byteArray = new byte[1];
        char[] charArray = new char[1];
        short[] shortArray = new short[1];
        int[] intArray = new int[1];
        long[] longArray = new long[1];
        float[] floatArray = new float[1];
        double[] doubleArray = new double[1];

        System.out.println("byte 类型数组默认值：" + byteArray[0]);
        System.out.println("char 类型数组默认值：" + charArray[0]);
        System.out.println("short 类型数组默认值：" + shortArray[0]);
        System.out.println("int 类型数组默认值：" + intArray[0]);
        System.out.println("long 类型数组默认值：" + longArray[0]);
        System.out.println("float 类型数组默认值：" + floatArray[0]);
        System.out.println("double 类型数组默认值：" + doubleArray[0]);
    }
}
