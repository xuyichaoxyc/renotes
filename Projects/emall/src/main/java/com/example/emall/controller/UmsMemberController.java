package com.example.emall.controller;

import com.example.emall.common.api.CommonResult;
import com.example.emall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author ：xuyichao
 * @description：
 *  会员登录注册管理Controller
 *  添加根据电话号码获取验证码的接口和校验验证码的接口
 * @date ：2021/6/1 14:13
 */
@Controller
@RequestMapping("/sso")
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @GetMapping("/getAuthCode")
    @ResponseBody
    @ApiOperation("获取验证码")
    public CommonResult getAuthCode(@RequestParam String telephone){
        return memberService.generateAuthCode(telephone);
    }

    @PostMapping(value="/verifyAuthCode")
    @ResponseBody
    @ApiOperation("判断验证码是否正确")
    public CommonResult verifyAuthCode (@RequestParam String telephone,
                                        @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }
    
}
