package com.xyc.learn.test.other;/**
 * @author ：xuyichao
 * @date ：Created By 2021/7/24 12:14
 * @description：测试公网ip
 * @modified By：
 * @version: $
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName IpController
 * @Description TODO
 * @Author xuyichao-xuyichao
 * @Date 2021/7/24 12:14
 * @Version 1.0
 **/
@Controller
@RequestMapping("/iptest")
public class IpController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "hello, ha!";
    }
}
