package com.xyc.db.springbootdb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {
    @Bean(name = "dataSource")
    public DataSource dataSource(Environment env) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(env.getProperty("dbusername"));
        dataSource.setPassword(env.getProperty("password"));
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setDriverClassName(env.getProperty("driver"));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("maxActive")));

        return dataSource;
    }
}
