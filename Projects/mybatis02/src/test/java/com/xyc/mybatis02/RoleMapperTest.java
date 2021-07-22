package com.xyc.mybatis02;/**
 * @author ：xuyichao
 * @date ：Created By 2021/7/19 22:28
 * @description：RoleMapper 测试
 * @modified By：
 * @version: 1.0.0$
 */

import com.xyc.mybatis02.entity.SysRole;
import com.xyc.mybatis02.entity.SysUser;
import com.xyc.mybatis02.mapper.RoleMapper;
import com.xyc.mybatis02.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 *@ClassName RoleMapperTest
 *@Description TODO
 *@Author xuyichao-xuyichao
 *@Date 2021/7/19 22:28
 *@Version 1.0
 **/
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectRoleById() {
        SqlSession sqlSession = getSqlSession();
        try{
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectRoleById(1L);
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            SysUser user = userMapper.selectById(1L);
//            System.out.println(user);
            Assert.assertNotNull(role);
            System.out.println(role);
            System.out.println(roleMapper.selectRoleById(1L));
            Assert.assertEquals("管理员", role.getRoleName());
        } finally {
            sqlSession.close();
        }
    }
}
