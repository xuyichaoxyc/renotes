package com.xyc.jpa.springbootjpa.service.impl;

import com.xyc.jpa.springbootjpa.dao.UserRepository;
import com.xyc.jpa.springbootjpa.entity.User;
import com.xyc.jpa.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userDao;

    @Override
    public Integer addUser(User user) {
        userDao.save(user);
        Integer id = user.getId();
        user.setName("1" + user.getName());
        userDao.save(user);
        return id;
    }

    @Override
    public List<User> findAllUserBySort() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return userDao.findAll(sort);
    }

    @Override
    public List<User> findAllUserByPage(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<User> pageObject = userDao.findAll(pageable);
        int totalPage = pageObject.getTotalPages();
        long count = pageObject.getTotalElements();

        return pageObject.getContent();
    }
}
