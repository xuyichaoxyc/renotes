package com.example.emall.dao;

import com.example.emall.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：xuyichao
 * @description：搜索系统中的商品管理自定义Dao
 * @date ：2021/6/1 14:13
 */
public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
