package com.qiushuang.seckill.dao;

import com.qiushuang.seckill.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 15:31
 * @description：
 * @modified By：
 * @version:
 */
@Mapper
public interface GoodsDao {
    List<Goods> getAll();

    Goods getGoodsById(@Param("goodsId") Long goodsId);

    void decrement(@Param("goodsId")Long goodsId);
}
