package com.xyc.db.springbootdb.service.impl;

import com.xyc.db.springbootdb.entity.User;
import com.xyc.db.springbootdb.repository.UserDao;
import com.xyc.db.springbootdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int getUserCount() {
        return userDao.getUserCount();
    }

    @Override
    public int getUserCount2() {
        return userDao.getUserCount2();
    }

    @Override
    public int getUserCount3(Long userId) {
        return userDao.getUserCount3(userId);
    }

    @Override
    public User getUser(Long userId) {
        return userDao.getUser(userId);
    }

    @Override
    public List<User> getUserByDepartmentId(Long departmentId) {
        return userDao.getUserByDepartmentId(departmentId);
    }

    @Override
    public Map findUserById2(Integer userId) {
        return userDao.findUserById2(userId);
    }

    @Override
    public void updateInfo(User user) {
        userDao.updateInfo(user);
    }

    @Override
    public void updateInfoByNamedJdbc(User user) {
        userDao.updateInfoByNamedJdbc(user);
    }

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public void insertUser2(User user) {
        userDao.insertUser2(user);
    }

}
