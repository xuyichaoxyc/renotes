package com.xyc.mybatis02.mapper;

import com.xyc.mybatis02.entity.SysPrivilege;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @InterfaceName PrivilegeMapper
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 15:11
 * @Version 1.0
 **/
public interface PrivilegeMapper {

    @Select({"select id, privilege_name, privilege_url from sys_privilege where id = #{id}"})
    SysPrivilege selectPrivilegeById(Long id);

    // mybatis 3.3.0
    /*
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "privilegeName", column = "privilege_name"),
            @Result(property = "privilegeUrl", column = "privilege_url")
    })
     */
    // mybatis 3.3.1
    @Results(id = "privilegeResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "privilegeName", column = "privilege_name"),
            @Result(property = "privilegeUrl", column = "privilege_url")
    })
    @Select("select id, privilege_name, privilege_url from sys_privilege where id = #{id}")
    SysPrivilege selectPrivilegeById2(Long id);

    @ResultMap("privilegeResultMap")
    @Select("select * from sys_privilege")
    List<SysPrivilege> selectAllPrivilege();


    /**
     * @Author xuyichao
     * @Description TODO 插入权限，不需要返回主键
     * @Date 2021/7/20 9:39
     * @param privilege
     * @return int
     **/
    @Insert({
            "insert into sys_privilege(id, privilege_name, privilege_url)",
            "values (#{id}, #{privilegeName}, #{privilegeUrl})"
    })
    int insertPrivilege(SysPrivilege privilege);


    /**
     * @Author xuyichao
     * @Description TODO 插入权限，返回自增主键
     * @Date 2021/7/20 9:40
     * @param privilege
     * @return int
     **/
    @Insert({
            "insert into sys_privilege(privilege_name, privilege_url)",
            "values (#{privilegeName}, #{privilegeUrl})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPrivilege2(SysPrivilege privilege);

    /**
     * @Author xuyichao
     * @Description TODO 插入权限，返回非自增主键
     * @Date 2021/7/20 10:04
     * @param privilege
     * @return int
     **/
    @Insert({
            "insert into sys_privilege(privilege_name, privilege_url)",
            "values (#{privilegeName}, #{privilegeUrl})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",
               keyProperty = "id",
               resultType = Long.class,
               before = false
    )
    int insertPrivilege3(SysPrivilege privilege);


    @Update({
            "update sys_privilege",
            "set privilege_name = #{privilegeName},",
            "privilege_url = #{privilegeUrl} ",
            "where id = #{id}"
    })
    int updatePrivilegeById(SysPrivilege privilege);


    @Delete({
            "delete from sys_privilege where id = #{id}"
    })
    int deletePrivilegeById(Long id);

}
