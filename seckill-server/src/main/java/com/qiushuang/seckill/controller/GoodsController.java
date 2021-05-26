package com.qiushuang.seckill.controller;

import com.github.pagehelper.PageInfo;
import com.qiushuang.seckill.controller.api.CommonResult;
import com.qiushuang.seckill.dao.GoodsDao;
import com.qiushuang.seckill.exception.NoGoodsException;
import com.qiushuang.seckill.pojo.Goods;
import com.qiushuang.seckill.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    private Logger logger= LoggerFactory.getLogger("GoodsController");

    @Autowired
    private GoodsService goodsService;


    @RequestMapping(method = RequestMethod.GET)
    public CommonResult getGoods(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize){
        List<Goods> goodsList=goodsService.getAll(pageNum,pageSize);
        return CommonResult.success(goodsList);
    }

    @RequestMapping(value = "/{goodsId}",method = RequestMethod.GET)
    public CommonResult getGoodsById(@PathVariable("goodsId") Long goodsId){
        Goods goods=goodsService.getGoodsById(goodsId);
        return CommonResult.success(goods);
    }

    @RequestMapping(value ="/buy/{goodsId}",method = RequestMethod.GET)
    public CommonResult buyGoods(@PathVariable("goodsId")Long goodsId){
        try {
            Boolean ans = goodsService.buyGoods(goodsId);
            return CommonResult.success(null);
        }catch (NoGoodsException exception){
            return CommonResult.failed(exception.getMessage());
        }catch (Exception exception){
            return CommonResult.failed();
        }
    }



}
