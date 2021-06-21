package chapter03_fileio.byteio;

import java.io.*;

/**
 * @author ：xuyichao
 * @description：字节缓冲输入输出流
 * @date ：2021/6/21 20:02
 */
public class BufferedTest {
    public static void bufferedTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        String name1 = "part02_chapter03_files/java.txt";
        String name2 = "part02_chapter03_files/copyjava.txt";

        int i;
        try{
            fis = new FileInputStream(name1);
            bis = new BufferedInputStream(bis);

            fos = new FileOutputStream(name2);
            bos = new BufferedOutputStream(bos);

            i = bis.read();
            while(i != -1){
                bos.write(i);
                i = bis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        bufferedTest();
    }

}
