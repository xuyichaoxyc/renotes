package com.xyc.jpa.springbootjpa.controller;

import com.xyc.jpa.springbootjpa.entity.User;
import com.xyc.jpa.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ch6")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public Integer addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping("/findalluserbysort")
    public List<User> findAllUserBySort() {
        return userService.findAllUserBySort();
    }

    @PostMapping("/findalluserbypage")
    public List<User> findAllUserByPage(int page, int size) {
        return userService.findAllUserByPage(page, size);
    }
}
