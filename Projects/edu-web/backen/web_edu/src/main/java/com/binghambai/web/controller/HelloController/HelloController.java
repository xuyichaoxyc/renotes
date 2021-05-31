package com.binghambai.web.controller.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一些声明信息
 * PackageName: com.binghambai.web.controller.HelloController
 * Description: <br/>
 * date: 2021/5/16 17:51<br/>
 *
 * @author binghambai<br />
 * @since JDK 1.8
 */

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
