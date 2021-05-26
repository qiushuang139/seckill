package com.qiushuang.seckill.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Order {
    private Long id;
    private Long goodsId;
    private Long userId;
    private Long deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private Double goodsPrice;
    private Integer orderChannel;
    private Integer status;
    private Date createDate;
    private Date payDate;
}
