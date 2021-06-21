package chapter03_fileio.byteio;

import java.io.*;

/**
 * @author ：xuyichao
 * @date ：Created By 2021/6/21 23:15
 * @description：字节数据输入输出流
 * @modified By：
 * @version: 1.0.0$
 */
public class DataIOStreamTest {
    public static void main(String[] args) {
        String filename = "part02_chapter03_files/DataioStreamTest.txt";
        People[] people = new People[]{
                new People("赵子龙", 23),
                new People("张三", 25),
                new People("李四", 27)
        };

        try{
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new FileOutputStream(filename)
            );
            for(People p : people){
                // 写入字符串
                dataOutputStream.writeUTF(p.getName());
                // 写入数据
                dataOutputStream.writeInt(p.getAge());
            }
            // 读出所有数据至目的地
            dataOutputStream.flush();
            // 关闭流
            dataOutputStream.close();


            DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream(filename)
            );
            for(int i = 0; i < people.length; i++){
                // 读出 UTF 字符串
                String name = dataInputStream.readUTF();
                // 读出 int 数据
                int score = dataInputStream.readInt();
                people[people.length-1-i] = new People(name, score);
            }
            // 关闭流
            dataInputStream.close();
            // 输出还原后的数据
            for(People p : people){
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
