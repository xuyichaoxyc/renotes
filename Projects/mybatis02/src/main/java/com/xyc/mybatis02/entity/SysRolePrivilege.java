package com.xyc.mybatis02.entity;

import lombok.Data;

/**
 * @ClassName SysRolePrivilege
 * @Description 角色权限表
 * @Author admin-xuyichao
 * @Date 2021/7/19 14:47
 * @Version 1.0
 **/
@Data
public class SysRolePrivilege {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long privilegeId;
}
