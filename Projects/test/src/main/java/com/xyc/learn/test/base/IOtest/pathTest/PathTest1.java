package com.xyc.learn.test.base.IOtest.pathTest;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName PathTest1
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/23 11:09
 * @Version 1.0
 **/
public class PathTest1 {
    public static void main(String[] args) {
        Path cur = Paths.get("..\\");
        System.out.println(cur.toAbsolutePath());
    }
}
