package com.xyc.springbootmybatis.mapper;

import com.xyc.springbootmybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName UserMapper
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 10:07
 * @Version 1.0
 **/
@Repository
public interface UserMapper {
    User sel(int id);
}
