package chapter03_fileio.byteio;

import java.io.*;

/**
 * @author ：xuyichao
 * @description：字节文件输入、输出流
 * @date ：2021/6/21 19:26
 */
public class InputStreamTest {
    public static void main(String[] args) {
        System.out.println(InputStreamTest.class.getResource(""));
        testStream();
    }
    /**
     * 字节流测试
     */
    public static void testStream(){
        InputStream fis = null;
        OutputStream fos = null;
        try{
            fis = new FileInputStream("part02_chapter03_files/x.txt");
//            fis = new FileInputStream("part02/chapter03_fileio/x.txt");
            fos = new FileOutputStream("part02_chapter03_files/xcopy.txt");

            long num = 0;
            int bt = 0;

            while((bt = fis.read()) != -1){
                System.out.println((char) bt);
                fos.write(bt);
                num++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
