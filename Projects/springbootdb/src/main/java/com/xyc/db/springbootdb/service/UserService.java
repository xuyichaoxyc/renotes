package com.xyc.db.springbootdb.service;

import com.xyc.db.springbootdb.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int getUserCount();

    public int getUserCount2();

    public int getUserCount3(Long userId);

    public User getUser(Long userId);

    public List<User> getUserByDepartmentId(Long departmentId);

    public Map findUserById2(Integer userId);

    public void updateInfo(User user);

    public void updateInfoByNamedJdbc(User user);

    public Integer insertUser(final User user);

    public void insertUser2(final User user);
}
