package com.xyc.mybatis02;

import com.xyc.mybatis02.entity.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName CountryMapperTest
 * @Description TODO
 * @Author admin-xuyichao
 * @Date 2021/7/19 16:06
 * @Version 1.0
 **/
public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAll() {

        SqlSession sqlSession = getSqlSession();
        try {
            List<Country> countryList = sqlSession.selectList("com.xyc.mybatis02.mapper.CountryMapper.selectAll");
            printCountryList(countryList);
        } finally {
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s\n",
                    country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
}
