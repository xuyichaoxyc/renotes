package com.example.emall.service;

import com.example.emall.common.api.CommonResult;

/**
 * @author ：xuyichao
 * @description：
 *  会员管理Service
 * @date ：2021/6/1 14:17
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
