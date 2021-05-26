package com.qiushuang.seckill.controller;

import com.qiushuang.seckill.controller.api.CommonResult;
import com.qiushuang.seckill.pojo.Order;
import com.qiushuang.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public CommonResult getOrders(@PathVariable("userId") Long userId,
                                  @RequestParam Integer pageNum,
                                  @RequestParam Integer pageSize){
        List<Order> orders=orderService.getOrders(userId,pageNum,pageSize);
        return CommonResult.success(orders);
    }

    @RequestMapping(value = "single/{orderId}",method = RequestMethod.GET)
    public CommonResult getOrderById(Long orderId){
        Order order=orderService.getOrderById(orderId);
        return CommonResult.success(order);
    }




}
