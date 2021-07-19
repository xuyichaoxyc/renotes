package com.xyc.mybatis02.mapper;

import com.xyc.mybatis02.entity.Country;

import java.util.List;

/**
 * @InterfaceName CountryMapper
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 16:26
 * @Version 1.0
 **/
public interface CountryMapper {

    /**
     * @Author xuyichao
     * @Description 查询所有 country
     * @Date 2021/7/19 16:26
     * @param
     * @return java.util.List<com.xyc.mybatis02.entity.Country>
     **/
    List<Country> selectAll();
}
