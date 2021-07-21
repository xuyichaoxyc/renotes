package com.xyc.mybatis02.mapper;

import com.xyc.mybatis02.entity.SysRole;
import com.xyc.mybatis02.entity.SysUser;
import org.apache.ibatis.annotations.Param;

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


    /**
     * @Author xuyichao
     * @Description 新增用户
     * @Date 2021/7/19 16:55
     * @param user
     * @return int
     **/
    int insert(SysUser user);

    /**
     * @Author xuyichao
     * @Description TODO 新增用户-使用useGeneratedKeys 方式
     * @Date 2021/7/19 17:08
     * @param user
     * @return int
     **/
    int insert2(SysUser user);


    /**
     * @Author xuyichao
     * @Description TODO 新增用户-使用selectKey方式
     * @Date 2021/7/19 17:12
     * @param user
     * @return int
     **/
    int insert3(SysUser user);

    /**
     * @Author xuyichao
     * @Description TODO 根据Id修改用户
     * @Date 2021/7/19 17:17
     * @param id
     * @return int
     **/
    int updateById(SysUser user);

    /**
     * @Author xuyichao
     * @Description TODO 根据Id 删除用户
     * @Date 2021/7/19 17:27
     * @param id
     * @return int
     **/
    int deleteById(Long id);

    int deleteById(SysUser user);

    /**
     * @Author xuyichao
     * @Description TODO 根据用户id和角色的enabled状态获取用户的角色
     * @Date 2021/7/19 21:55
     * @param userId
     * @param enabled
     * @return java.util.List<com.xyc.mybatis02.entity.SysRole>
     **/
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer enabled);
//    List<SysRole> selectRolesByUserIdAndRoleEnabled(Long userId, Integer enabled);

    /**
     * @Author xuyichao
     * @Description TODO
     * @Date 2021/7/19 22:25
     * @param user
     * @return java.util.List<com.xyc.mybatis02.entity.SysRole>
     **/
    List<SysRole> selectRolesByUserAndRole(@Param("user") SysUser user, @Param("role") SysRole role);


    /**
     * @Author xuyichao
     * @Description TODO 根据用户名或邮箱查询用户
     * @Date 2021/7/20 10:56
     * @param user
     * @return java.util.List<com.xyc.mybatis02.entity.SysRole>
     **/
    List<SysUser> selectUserByUser(SysUser user);


    int updateUserByIdSelective(SysUser user);

    /**
     * @Author xuyichao
     * @Description TODO 根据用户 id 获取用户信息和用户的角色信息
     * @Date 2021/7/21 16:20
     * @param id
     * @return com.xyc.mybatis02.entity.SysUser
     **/
    SysUser selectUserAndRoleById(Long id);
}
