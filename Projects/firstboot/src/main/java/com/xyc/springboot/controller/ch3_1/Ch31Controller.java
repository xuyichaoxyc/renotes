package com.xyc.springboot.controller.ch3_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 17:26
 */
@Controller
@RequestMapping("/ch31")
public class Ch31Controller {
    @RequestMapping("/userdetail.html")
    public String foo(String id) {
        System.out.println("ch31 /userdetail.html");
        return "/admin/userInfo.btl";
    }
}
