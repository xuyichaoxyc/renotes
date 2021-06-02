package com.example.emall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：徐义超
 * @description：MyBatis配置类，用于配置需要动态生成的mapper接口的路径
 * @date ：2021/6/1 9:41
 */
@Configuration
@MapperScan({"com.example.emall.mbg.mapper","com.example.emall.dao"})
public class MyBatisConfig {
}
