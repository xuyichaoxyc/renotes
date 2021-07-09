package com.xyc.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/8 19:44
 */
@RestController
public class RestTestController {
    @RequestMapping("/user/{id}")
    public Integer getCreditLevel(@PathVariable String id) {
        setTest();
        return Integer.parseInt(id);
    }

    public void setTest() {
        System.out.println("set 方法......");
    }
}
