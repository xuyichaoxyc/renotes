package com.xyc.mybatis02.entity;

import lombok.Data;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName SysUser
 * @Description 用户表
 * @Author admin-xuyichao
 * @Date 2021/7/19 14:35
 * @Version 1.0
 **/
@Data
public class SysUser {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     **/
    private String userPassword;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * @Author xuyichao
     * @Description 简介
     **/
    private String userInfo;

    /**
     * @Author xuyichao
     * @Description 头像
     **/
    private byte[] headImg;

    /**
     * @Author xuyichao
     * @Description 创建时间
     **/
    private Date createTime;
}
