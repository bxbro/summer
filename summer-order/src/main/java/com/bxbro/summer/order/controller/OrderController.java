package com.bxbro.summer.order.controller;

import com.bxbro.summer.common.domain.entity.Order;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.order.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.http.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/ids")
    public BaseResponse getOrdersByIds(@RequestParam("ids") String ids) {
        Asserts.notNull(ids, "ids不能为空.");
        String[] idArray = ids.split(",");
        List<Order> orderList = new ArrayList<>();
        for (String id : idArray) {
            Order order = orderService.getById(id);
            orderList.add(order);
        }
        return BaseResponse.success(orderList);
    }

}
