package com.xyc.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/8 19:02
 */
@Controller
public class HttpTestController {
    @GetMapping(value="/hello.html")
    public @ResponseBody String helloBoot(){
        return "Hello SpringBooot!";
    }
    
}
