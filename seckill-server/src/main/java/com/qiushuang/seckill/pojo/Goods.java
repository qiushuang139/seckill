package com.qiushuang.seckill.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodsStock;

    public boolean decrement(){
        if(this.goodsStock>0) {
            this.goodsStock--;
            return true;
        }
        return false;
    }
}
