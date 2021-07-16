package com.xyc.springboot.controller.ch3_7;

import com.xyc.springboot.entity.User;
import com.xyc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 14:54
 */
@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {

    @Autowired
    UserService userService;
    /***
     * http://127.0.0.1:8080/freemarker//showuser.html?id=1
     * @param id
     * @return
     */
    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(Long id){
        ModelAndView view = new ModelAndView();
        User user = userService.getUserById(id);
        view.addObject("user", user);
        view.setViewName("/userInfo");
        return view;
    }

}
