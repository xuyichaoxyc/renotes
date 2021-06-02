package com.example.emall.service;


import com.example.emall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/1 10:01
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
