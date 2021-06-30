package chapter03_fileio.chario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/22 8:34
 * @description：
 *              文件读写字符流，FileReader、FileWriter，
 *              分别继承自InputStreamReader与OutputStreamReader
 *              使用文件输入输出流，可以直接指定文件名或者File打开指定文件
 *                  如果只输入文件名，这个文件的默认地址为项目的根目录
 *                  如果使用 File，就可以引入源文件的相对路径或绝对路径了
 *              若需要指定编码，则需要使用 InputStreamReader以及 OutputStreamWriter
 *              InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gb2312")
 *
 *
 *              FileReader(String filenmae)、FileReader(File file)
 *              FileWriter(String filename)、FileWriter(String filename, Boolean b)
 *              FileWriter(File file)、FileWriter(File file, Boolean b)
 *
 *              true,在原有文件内容后面追加新内容
 *              false，在文件开头部分写入新内容
 * @modified By：
 * @version: 1.0.0$
 */
public class FileReaderTest {
    public static void filereadertest(){
        String name = "part02_chapter03_files/javatest.txt";

        try {
            FileReader fr = new FileReader(name);
            char[] c = new char[1];
            while(fr.read(c) != -1){
                System.out.println(new String(c));
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        filereadertest();
    }
}
