package com.xyc.springboot.service.impl;

import com.xyc.springboot.entity.User;
import com.xyc.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/9 15:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> allUser() {
        return SampleUser(5);
    }

    @Override
    public User getUserById(Long id) {
        User user = SampleUser(1).get(0);
        user.setId(id);
        return user;
    }

    @Override
    public void updateUser(Long id, Integer type) {

    }

    public List<User> SampleUser(int num) {
        List<User> list = new ArrayList<User>(num);

        for (int i = 0; i < num; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("name" + i);
            list.add(user);
        }

        return list;
    }
}
