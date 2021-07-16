package com.xyc.db.springbootdb.controller;

import com.xyc.db.springbootdb.entity.User;
import com.xyc.db.springbootdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ch5")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getusercount")
    @ResponseBody
    public int getUserCount() {
        return userService.getUserCount();
    }

    @RequestMapping("/getusercount2")
    @ResponseBody
    public int getUserCount2() {
        return userService.getUserCount2();
    }

    @RequestMapping("/getusercount3/{userId}")
    @ResponseBody
    public int getUserCount3(@PathVariable Long userId) {
        return userService.getUserCount3(userId);
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.POST)
    @ResponseBody
    public User getUser(Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping(value = "/getuserbydepartment")
    @ResponseBody
    public List<User> getUserByDepartmentId(Long departmentId) {
        return userService.getUserByDepartmentId(departmentId);
    }

    @PostMapping(value = "/finduserbyid2")
    @ResponseBody
    public Map findUserById2(Integer userId) {
        return userService.findUserById2(userId);
    }

    @PostMapping(value = "/updateinfo")
    @ResponseBody
    public void updateInfo(User user) {
        userService.updateInfo(user);
    }

    @PostMapping(value = "/updateinfobynamedjdbc")
    @ResponseBody
    public void updateInfoByNamedJdbc(User user) {
        userService.updateInfoByNamedJdbc(user);
    }

    @PostMapping(value = "/insertuser")
    @ResponseBody
    public Integer insertUser(User user) {
        return userService.insertUser(user);
    }

    @PostMapping(value = "/insertuser2")
    @ResponseBody
    public String insertUser2(@RequestBody User user) {
        System.out.println("begin: ");
        userService.insertUser2(user);
        return "result" + user;
    }
}
