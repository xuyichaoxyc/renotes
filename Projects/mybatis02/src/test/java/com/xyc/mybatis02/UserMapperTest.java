package com.xyc.mybatis02;

import com.xyc.mybatis02.entity.SysRole;
import com.xyc.mybatis02.entity.SysUser;
import com.xyc.mybatis02.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

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
}
