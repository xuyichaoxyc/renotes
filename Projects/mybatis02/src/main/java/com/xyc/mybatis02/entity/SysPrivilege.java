package com.xyc.mybatis02.entity;

import lombok.Data;

/**
 * @ClassName SysPrivilege
 * @Description 权限表
 * @Author admin-xuyichao
 * @Date 2021/7/19 14:44
 * @Version 1.0
 **/
@Data
public class SysPrivilege {
    /**
     * 权限ID
     */
    private Long id;

    /**
     * 权限名
     */
    private String privilegeName;

    /**
     * 权限URL
     */
    private String privilegeUrl;
}
