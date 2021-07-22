package com.xyc.springbootmybatis.entity;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 10:01
 * @Version 1.0
 **/
@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;


    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", userName = " + userName +
                ", passWord = " + passWord +
                ", realName = " + realName;
    }
}
