package com.example.emall.service;

import com.example.emall.common.api.CommonResult;
import com.example.emall.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：xuyichao
 * @description：前台订单管理Service
 * @date ：2021/6/3 14:27
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
