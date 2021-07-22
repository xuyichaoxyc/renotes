package com.xyc.vueblog.springbootvueblog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName MybatisPlusConfig
 * @Description Mybatis 配置类
 * @Author admin-xuyichao
 * @Date 2021/7/19 8:44
 * @Version 1.0
 **/
@Configuration
@EnableTransactionManagement
@MapperScan("com.xyc.vueblog.springbootvueblog.mapper")
public class MybatisPlusConfig {
    /**
     * @Author xuyichao
     * @Description PaginationInterceptor 一个分页插件
     * @Date 2021/7/19 8:48
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
