package com.xyc.mybatis02.mapper;

import com.xyc.mybatis02.entity.SysUser;

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
}
