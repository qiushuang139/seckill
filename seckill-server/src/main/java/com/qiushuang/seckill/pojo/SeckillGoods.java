package com.qiushuang.seckill.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 16:20
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class SeckillGoods {
    Long id;
    Long goodsId;
    Double price;
    Integer stockCount;
    Date startDate;
    Date endDate;
}
