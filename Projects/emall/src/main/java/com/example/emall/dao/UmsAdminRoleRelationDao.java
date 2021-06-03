package com.example.emall.dao;



import com.example.emall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：xuyichao
 * @description：后台用户与角色管理自定义Dao
 * @date ：2021/6/1 14:13
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
