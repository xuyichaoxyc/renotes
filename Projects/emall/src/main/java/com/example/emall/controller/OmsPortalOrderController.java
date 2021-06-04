package com.example.emall.controller;

import com.example.emall.dto.OrderParam;
import com.example.emall.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ：xuyichao
 * @description：订单管理Controller
 * @date ：2021/6/3 14:33
 */
@Controller
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;
    
    @PostMapping(value="/generateOrder")
    @ApiOperation("根据购物车信息生成订单")
    @ResponseBody
    public Object generateOrder (@RequestBody OrderParam orderParam) {
        return portalOrderService.generateOrder(orderParam);
    }
    
}
