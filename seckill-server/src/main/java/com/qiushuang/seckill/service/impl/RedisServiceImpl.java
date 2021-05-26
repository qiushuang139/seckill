package com.qiushuang.seckill.service.impl;

import com.qiushuang.seckill.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 11:53
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void setStr(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void setNum(String key,Integer value){
        redisTemplate.opsForValue().set(key,value.toString());
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    //设置超时时间
    @Override
    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key,expire, TimeUnit.SECONDS);
    }

    //删除数据
    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    //以增量的方式将值存储在变量中
    @Override
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key,delta);
    }
}
