package com.xyc.mybatis02;/**
 * @author ：xuyichao
 * @date ：Created By 2021/7/21 21:05
 * @description：缓存测试
 * @modified By：
 * @version: 1.0.0$
 */

import com.xyc.mybatis02.entity.SysUser;
import com.xyc.mybatis02.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName CacheTest
 * @Description TODO
 * @Author xuyichao-xuyichao
 * @Date 2021/7/21 21:05
 * @Version 1.0
 **/
public class CacheTest extends BaseMapperTest {
    @Test
    public void testL1Cache() {
        SqlSession sqlSession = getSqlSession();
        SysUser user1 = null;
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user1 = userMapper.selectById(1L);
            user1.setUserName("New Name");
            SysUser user2 = userMapper.selectById(1L);
            Assert.assertEquals("New Name", user2.getUserName());
            Assert.assertEquals(user1, user2);
        } finally {
            sqlSession.close();
        }
        System.out.println("开启新的SqlSession");
        sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user2 = userMapper.selectById(1L);

            Assert.assertNotEquals("New Name", user2.getUserName());
            Assert.assertNotEquals(user1, user2);
            userMapper.deleteById(2L);
            SysUser user3 = userMapper.selectById(1L);
            Assert.assertEquals(user2, user3);
        } finally {
            sqlSession.close();
        }
    }
}
