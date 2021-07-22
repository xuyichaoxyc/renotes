package com.xyc.mybatis02.mapper;

import com.xyc.mybatis02.entity.SysRole;

/**
 * @InterfaceName RoleMapper
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 15:11
 * @Version 1.0
 **/
public interface RoleMapper {

    /**
     * @Author xuyichao
     * @Description TODO 根据id查找角色
     * @Date 2021/7/19 22:27
     * @param id
     * @return com.xyc.mybatis02.entity.SysRole
     **/
    SysRole selectRoleById(Long id);
}
