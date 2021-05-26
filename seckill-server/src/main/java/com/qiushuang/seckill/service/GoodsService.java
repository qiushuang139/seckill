package com.qiushuang.seckill.service;
import com.qiushuang.seckill.pojo.Goods;

import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2021/5/26 15:22
 * @description：
 * @modified By：
 * @version:
 */

public interface GoodsService {
    List<Goods> getAll(Integer pageNum,Integer pageSize);

    Goods getGoodsById(Long goodsId);

    Boolean buyGoods(Long goodsId) throws Exception;
}
