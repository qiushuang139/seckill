package com.qiushuang.seckill.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.qiushuang.seckill.dao.OrderDao;
import com.qiushuang.seckill.pojo.Order;
import com.qiushuang.seckill.service.OrderService;
import com.qiushuang.seckill.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 17:06
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RedisService redisService;

    @Override
    public List<Order> getOrders(Long userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list=orderDao.getOrders(userId);
        return list;
    }

    @Override
    public Order getOrderById(Long orderId) {
        String key="order"+orderId;
        String value=redisService.get(key);
        Order order;
        if(StringUtils.isEmpty(value)){
            order=orderDao.getOrderById(orderId);
        }else{
            order= JSON.parseObject(value,Order.class);
        }
        return order;
    }
}
