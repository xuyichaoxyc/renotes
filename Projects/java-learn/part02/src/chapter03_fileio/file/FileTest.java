package chapter03_fileio.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * @author ：xuyichao
 * @date ：Created By 22021/6/22 9:24
 * @description：
 *              File 类
 * @modified By：
 * @version: 1.0.0$
 */
public class FileTest {
    public void readFileList(File file, Filter filter){
        // 判断 file 是否为目录
        if(file.isDirectory()){
            // 创建目录数组
            File[] files = file.listFiles(filter);

            ArrayList<File> fileList = new ArrayList<File>();

            for(int i = 0; i < files.length; i++){
                if(files[i].isDirectory()) {
                    System.out.println(files[i]);
                    System.out.println("[" + files[i].getPath() + "]");
                    readFileList(files[i], filter);
                }
                else{
                    // 文件先存入 fileList
                    fileList.add(files[i]);
                }
            }

            for(File f : fileList){
                readFileList(f, filter);
            }
            System.out.println();
        }
        else{
            FileDesc(file);
        }
    }

    public void FileDesc(File file){
        if(file.isFile()){
            // 输出字符串信息
            System.out.print(file.toString() + "\n该文件");
            // 判断文件是否可读
            System.out.println(file.canRead() ? "可读" : "不可读");
            // 判断文件是否可写
            System.out.println(file.canWrite() ? "可写" : "不可写");
            // 输出字节数
            System.out.println(file.length() + "字节");
        }
    }

    public static void main(String[] args) {
        String filename = "part02_chapter03_files\\";
        File file = new File(filename);
        Filter filter = new Filter("txt");
        new FileTest().readFileList(file, filter);
    }
}

class Filter implements FilenameFilter{
    // 扩展名
    String extent;
    // Filter 的构造方法
    Filter(String extent){
        this.extent = extent;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("." + extent);
    }
}