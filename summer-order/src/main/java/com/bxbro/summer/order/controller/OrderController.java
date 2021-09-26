package com.bxbro.summer.order.controller;

import com.bxbro.summer.common.domain.entity.Order;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.common.util.AssertUtils;
import com.bxbro.summer.order.service.IOrderService;
import io.swagger.annotations.ApiOperation;
import org.apache.http.util.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger =
            LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService orderService;


    @ApiOperation("根据订单id查询订单详情")
    @GetMapping("/{id}")
    public BaseResponse getOrderById(@PathVariable("id") Integer id) {
        logger.info("=====进入getOrderById方法========");
//        Asserts.notNull(id, "id不能为空.");
        AssertUtils.notNull(id, "id不能为空.");
        Order order = orderService.getById(id);
        return BaseResponse.success(order);
    }


    /**
     * 服务提供方需要提供一个支持批量查询订单的接口，如此，服务调用方才可以用hystrix的请求合并器
     * @param ids
     * @return
     */
    @ApiOperation("批量查询订单")
    @GetMapping
    public BaseResponse getOrdersByIds(@RequestParam("ids") String ids) {
        logger.info("============进入getOrdersByIds方法==============");
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
