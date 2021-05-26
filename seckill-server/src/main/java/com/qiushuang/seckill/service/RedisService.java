package com.qiushuang.seckill.service;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 11:51
 * @description：
 * @modified By：
 * @version:
 */
public interface RedisService {
    void setStr(String key, String value);
    void setNum(String key,Integer value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
