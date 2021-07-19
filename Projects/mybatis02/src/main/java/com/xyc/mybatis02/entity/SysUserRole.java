package com.xyc.mybatis02.entity;

import lombok.Data;

/**
 * @ClassName SysUserRole
 * @Description 用户角色表
 * @Author admin-xuyichao
 * @Date 2021/7/19 14:46
 * @Version 1.0
 **/
@Data
public class SysUserRole {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
}
