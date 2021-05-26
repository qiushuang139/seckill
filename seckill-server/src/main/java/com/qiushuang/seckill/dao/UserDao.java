package com.qiushuang.seckill.dao;

import com.qiushuang.seckill.param.LoginParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/25 18:58
 * @description：
 * @modified By：
 * @version:
 */
@Mapper
public interface UserDao {
    LoginParam getLoginParam(@Param("userId") String userId);
}
