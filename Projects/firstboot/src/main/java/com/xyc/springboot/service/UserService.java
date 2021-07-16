package com.xyc.springboot.service;

import com.xyc.springboot.entity.User;

import java.util.List;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 15:03
 */
public interface UserService {
    public List<User> allUser();

    public User getUserById(Long id);

    public void updateUser(Long id, Integer type);
}
