package com.xyc.vueblog.springbootvueblog.service.impl;

import com.xyc.vueblog.springbootvueblog.entity.Blog;
import com.xyc.vueblog.springbootvueblog.mapper.BlogMapper;
import com.xyc.vueblog.springbootvueblog.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
