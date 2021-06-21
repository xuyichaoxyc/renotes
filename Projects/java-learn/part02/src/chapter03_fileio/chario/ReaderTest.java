package chapter03_fileio.chario;

import java.io.*;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/22 0:24
 * @description：字符输入输出流
 * @modified By：
 * @version: 1.0.0$
 */
public class ReaderTest {
    public static void reader() throws IOException {
        /**
         * 字符流测试
         */
        FileInputStream fileInputStream = new FileInputStream("part02_chapter03_files/x.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String ss = new String();
        String s;

        while((s = bufferedReader.readLine()) != null)
        {
            ss += s;
        }

        FileOutputStream fileOutputStream = new FileOutputStream("part02_chapter03_files/xcopy.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        bufferedWriter.write(ss);
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        reader();
    }
}
