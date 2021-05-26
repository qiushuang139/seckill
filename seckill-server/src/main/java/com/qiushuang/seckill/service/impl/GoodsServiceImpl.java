package com.qiushuang.seckill.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.qiushuang.seckill.dao.GoodsDao;
import com.qiushuang.seckill.exception.NoGoodsException;
import com.qiushuang.seckill.pojo.Goods;
import com.qiushuang.seckill.service.GoodsService;
import com.qiushuang.seckill.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 15:24
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger LOGGER=LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> list=goodsDao.getAll();
        return list;
    }

    @Override
    public Goods getGoodsById(Long goodsId){
        String key="goods"+goodsId;
        String value= redisService.get(key);
        if(StringUtils.isEmpty(value)){
            return goodsDao.getGoodsById(goodsId);
        }else{
            return JSON.parseObject(value,Goods.class);
        }
    }

    @Override
    public Boolean buyGoods(Long goodsId) throws Exception{
        String key="goods"+goodsId;
        String value= redisService.get(key);
        Goods goods;
        if(StringUtils.isEmpty(value)){//redis缓存中不存在商品
            goods=goodsDao.getGoodsById(goodsId);
        }else{//商品中存在该商品
            goods=JSON.parseObject(redisService.get(key),Goods.class);
        }
        if(!goods.decrement()){
            throw new NoGoodsException();
        }
        value= JSON.toJSONString(goods);
        redisService.setStr(key,value);
        goodsDao.decrement(goodsId);
        return true;
    }
}
