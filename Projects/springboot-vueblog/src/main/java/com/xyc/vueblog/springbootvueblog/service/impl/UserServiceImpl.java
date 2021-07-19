package com.xyc.vueblog.springbootvueblog.service.impl;

import com.xyc.vueblog.springbootvueblog.entity.User;
import com.xyc.vueblog.springbootvueblog.mapper.UserMapper;
import com.xyc.vueblog.springbootvueblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-07-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
