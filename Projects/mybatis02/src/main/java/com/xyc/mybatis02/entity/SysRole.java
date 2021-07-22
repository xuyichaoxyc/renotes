package com.xyc.mybatis02.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName SysRole
 * @Description 角色表
 * @Author admin-xuyichao
 * @Date 2021/7/19 14:41
 * @Version 1.0
 **/
@Data
public class SysRole {
    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 有效标识
     */
    private Integer enabled;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    private SysUser user;
}
