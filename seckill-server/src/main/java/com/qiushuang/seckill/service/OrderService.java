package com.qiushuang.seckill.service;

import com.qiushuang.seckill.pojo.Order;

import java.util.List;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 17:06
 * @description：
 * @modified By：
 * @version:
 */
public interface OrderService {
    List<Order> getOrders(Long userId,Integer pageNum,Integer pageSize);

    Order getOrderById(Long orderId);
}
