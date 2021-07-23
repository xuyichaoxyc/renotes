package com.xyc.learn.test.base.IOtest.pathTest;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName PathTest2
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 11:13
 * @Version 1.0
 **/
public class PathTest2 {
    public static void main(String[] args) {
        Path listing1 = Paths.get("D:/learning/gitfile/renotes/Projects/test/IOtest/pathTest/PathTest1.java");
        Path listing2 = FileSystems.getDefault().getPath("D:/learning/gitfile/renotes/Projects/test");

        System.out.println(listing1);
        System.out.println(listing2);

        System.out.println(listing1.toAbsolutePath());

        Path path = Paths.get("PathTest1.java");
        System.out.println(path.toAbsolutePath());
        System.out.println(path.getFileSystem());
        System.out.println(path.getParent());

    }
}
