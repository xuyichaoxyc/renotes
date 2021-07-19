package com.xyc.springbootmybatis.service.impl;

import com.xyc.springbootmybatis.entity.User;
import com.xyc.springbootmybatis.mapper.UserMapper;
import com.xyc.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImp
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 10:06
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User sel(int id) {
        return userMapper.sel(id);
    }
}
