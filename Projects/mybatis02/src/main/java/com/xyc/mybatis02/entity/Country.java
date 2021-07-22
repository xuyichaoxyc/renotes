package com.xyc.mybatis02.entity;

import lombok.Data;

/**
 * @ClassName Country
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 11:32
 * @Version 1.0
 **/
@Data
public class Country {
    private Long id;
    private String countryname;
    private String countrycode;
}
