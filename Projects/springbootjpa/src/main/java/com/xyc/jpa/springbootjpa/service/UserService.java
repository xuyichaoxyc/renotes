package com.xyc.jpa.springbootjpa.service;

import com.xyc.jpa.springbootjpa.entity.User;

import java.util.List;

public interface UserService {
    public Integer addUser(User user);

    public List<User> findAllUserBySort();

    public List<User> findAllUserByPage(int page, int size);
}
