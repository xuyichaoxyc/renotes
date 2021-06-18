package com.xyc.learn.sub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/8 11:26
 */
@RestController
public class ProviderController {
    @GetMapping("/person/{personId}")
    public String findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request){
        return "return person " + personId + request.getRequestURI().toString();
    }
}
