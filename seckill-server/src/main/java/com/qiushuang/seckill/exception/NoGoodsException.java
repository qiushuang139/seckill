package com.qiushuang.seckill.exception;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 16:23
 * @description：
 * @modified By：
 * @version:
 */
public class NoGoodsException extends Exception{

    public NoGoodsException(){
        super("商品已售罄");
    }
}
