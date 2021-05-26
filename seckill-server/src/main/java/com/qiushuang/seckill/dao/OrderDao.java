package com.qiushuang.seckill.dao;

import com.qiushuang.seckill.pojo.Order;

import java.util.List;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 17:09
 * @description：
 * @modified By：
 * @version:
 */
public interface OrderDao {
    List<Order> getOrders(Long userId);

    Order getOrderById(Long orderId);
}
