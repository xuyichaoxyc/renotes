package com.xyc.springbootmybatis.controller;

import com.xyc.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 10:04
 * @Version 1.0
 **/
@RestController
@RequestMapping("/testBoot")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        return userService.sel(id).toString();
    }
}
