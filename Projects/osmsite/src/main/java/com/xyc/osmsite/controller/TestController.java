package com.xyc.osmsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/16 9:00
 * @Version 1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getdirect/{path}")
    @ResponseBody
    public List<String> getDirect1(@PathVariable String path){

        if ("#".equals(path)) {
            return getDirect("./");
        }

        return getDirect(path);

    }

    public List<String> getDirect(String path){
        List<String> result = new ArrayList<>();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    System.out.println("目录：" + files[i].getPath());
                    result.add(files[i].getPath());
                    getDirect(files[i].getPath());
                } else {
                    System.out.println("文件： " + files[i].getName());
                }
            }
        } else {
            System.out.println("文件： " + file.getName());
        }
        return result;
    }
}
