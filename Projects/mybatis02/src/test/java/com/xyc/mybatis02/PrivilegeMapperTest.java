package com.xyc.mybatis02;

import com.xyc.mybatis02.entity.SysPrivilege;
import com.xyc.mybatis02.mapper.PrivilegeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName PrivilegeMapperTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/20 9:06
 * @Version 1.0
 **/
public class PrivilegeMapperTest extends BaseMapperTest {
    @Test
    public void testSelectPrivilegeById() {
        SqlSession sqlSession = getSqlSession();
        try {

            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            SysPrivilege privilege = privilegeMapper.selectPrivilegeById(1L);

            Assert.assertNotNull(privilege);
            Assert.assertEquals("用户管理", privilege.getPrivilegeName());

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectPrivilegeById2() {
        SqlSession sqlSession = getSqlSession();
        try {

            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            SysPrivilege privilege = privilegeMapper.selectPrivilegeById2(1L);

            Assert.assertNotNull(privilege);
            Assert.assertEquals("用户管理", privilege.getPrivilegeName());

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAllPrivilege() {
        SqlSession sqlSession = getSqlSession();
        try {

            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            List<SysPrivilege> privilegeList = privilegeMapper.selectAllPrivilege();

            Assert.assertNotNull(privilegeList);
            Assert.assertTrue(privilegeList.size() > 0);

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertPrivilege() {
        SqlSession sqlSession = getSqlSession();
        try {

            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            SysPrivilege privilege = privilegeMapper.selectPrivilegeById(5L);
            privilege.setId(6L);
            int result = privilegeMapper.insertPrivilege(privilege);

            Assert.assertEquals(1, result);
            Assert.assertNotNull(privilegeMapper.selectPrivilegeById(6L));

        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsertPrivilege2() {
        SqlSession sqlSession = getSqlSession();
        try {

            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            SysPrivilege privilege = new SysPrivilege();
            privilege.setPrivilegeName("sss");
            privilege.setPrivilegeUrl("/test/insert2");
            int result = privilegeMapper.insertPrivilege2(privilege);

            Assert.assertEquals(1, result);
            Assert.assertNotNull(privilege.getId());
            System.out.println(privilege.getId());

        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsertPrivilege3() {
        SqlSession sqlSession = getSqlSession();
        try {

            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            SysPrivilege privilege = new SysPrivilege();
            privilege.setPrivilegeName("sss");
            privilege.setPrivilegeUrl("/test/insert2");
            int result = privilegeMapper.insertPrivilege3(privilege);

            Assert.assertEquals(1, result);
            Assert.assertNotNull(privilege.getId());

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdatePrivilegeById() {
        SqlSession sqlSession = getSqlSession();
        try {
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            SysPrivilege privilege = new SysPrivilege();
            privilege.setId(1L);
            privilege.setPrivilegeName("update");
            privilege.setPrivilegeUrl("/update");
            int result = privilegeMapper.updatePrivilegeById(privilege);

            Assert.assertEquals(1, result);
            Assert.assertEquals("update", privilegeMapper.selectPrivilegeById(1L).getPrivilegeName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDeletePrivilegeById() {
        SqlSession sqlSession = getSqlSession();
        try {
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            int result = privilegeMapper.deletePrivilegeById(1L);

            Assert.assertEquals(1, result);
            Assert.assertNull(privilegeMapper.selectPrivilegeById(1L));
        } finally {
            sqlSession.close();
        }
    }
}
