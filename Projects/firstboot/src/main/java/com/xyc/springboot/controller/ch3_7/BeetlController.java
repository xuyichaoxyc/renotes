package com.xyc.springboot.controller.ch3_7;

import com.xyc.springboot.entity.User;
import com.xyc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 17:22
 */
@Controller
@RequestMapping("/beetl")
public class BeetlController {
    @Autowired
    UserService userService;

    @RequestMapping("/index.html")
    public  String say(Model model){
        model.addAttribute("name","hello,world");
        return "/index.btl";
    }

    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(Long id){
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(id);
        view.addObject("user",user);
        view.setViewName("/userInfo.btl");
        return view;
    }


}
