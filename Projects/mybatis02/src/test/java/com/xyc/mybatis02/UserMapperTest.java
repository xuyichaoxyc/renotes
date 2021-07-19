package com.xyc.mybatis02;

import com.xyc.mybatis02.entity.SysRole;
import com.xyc.mybatis02.entity.SysUser;
import com.xyc.mybatis02.mapper.RoleMapper;
import com.xyc.mybatis02.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 15:44
 * @Version 1.0
 **/
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        // 获取 SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取 UserMapper 接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1l);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void testselectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mmmmx.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            int result = userMapper.insert(user);

            Assert.assertEquals(1, result);
            Assert.assertNull(user.getId());
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mmmmx.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            int result = userMapper.insert2(user);

            Assert.assertEquals(1, result);
            Assert.assertNotNull(user.getId());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mmmmx.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            int result = userMapper.insert3(user);

            Assert.assertEquals(1, result);
            Assert.assertNotNull(user.getId());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("admin", user.getUserName());

            user.setId(1L);
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mmmmx.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            int result = userMapper.updateById(user);

            Assert.assertEquals(1, result);
            user = userMapper.selectById(1L);
            Assert.assertEquals("test1", user.getUserName());
        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user1 = userMapper.selectById(1L);
            Assert.assertNotNull(user1);

            Assert.assertEquals(1, userMapper.deleteById(1L));
            Assert.assertNull(userMapper.selectById(1L));

            SysUser user2 = userMapper.selectById(1001L);
            Assert.assertNotNull(user2);
            Assert.assertEquals(1, userMapper.deleteById(user2));
            Assert.assertNull(userMapper.selectById(1001L));

        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);

            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserAndRole() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysUser user = userMapper.selectById(1L);
            SysRole role = roleMapper.selectRoleById(1L);

            List<SysRole> roleList = userMapper.selectRolesByUserAndRole(user, role);

            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);

        } finally {
            sqlSession.close();
        }
    }
}
