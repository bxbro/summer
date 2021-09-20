package com.bxbro.summer.order.controller;

import com.bxbro.summer.common.domain.entity.Order;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.order.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.http.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dong
 * @description TODO
 * @date 2021/9/20
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @ApiOperation("根据订单id查询订单详情")
    @GetMapping("/{id}")
    public BaseResponse getOrderById(@PathVariable("id") Integer id) {
        Asserts.notNull(id, "id不能为空.");
        Order order = orderService.getById(id);
        return BaseResponse.success(order);
    }

}
