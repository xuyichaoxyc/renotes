package com.xyc.mybatis02.mapper;

import com.xyc.mybatis02.entity.SysRole;
import com.xyc.mybatis02.entity.SysUser;

import java.util.List;

/**
 * @InterfaceName UserMapper
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 15:11
 * @Version 1.0
 **/
public interface UserMapper {

    /**
     * @Author xuyichao
     * @Description 通过 id 查询用户
     * @Date 2021/7/19 15:17
     * @param id
     * @return com.xyc.mybatis02.entity.SysUser
     **/
    SysUser selectById(Long id);

    /**
     * @Author xuyichao
     * @Description 查询所有用户
     * @Date 2021/7/19 15:57
     * @param
     * @return java.util.List<com.xyc.mybatis02.entity.SysUser>
     **/
    List<SysUser> selectAll();

    /**
     * @Author xuyichao
     * @Description 根据用户ID查询角色信息
     * @Date 2021/7/19 16:31
     * @param userId
     * @return java.util.List<com.xyc.mybatis02.entity.SysRole>
     **/
    List<SysRole> selectRolesByUserId(Long userId);
}
