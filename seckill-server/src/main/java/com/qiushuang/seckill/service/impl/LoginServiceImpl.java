package com.qiushuang.seckill.service.impl;

import com.qiushuang.seckill.dao.UserDao;
import com.qiushuang.seckill.exception.WrongUserNameOrPasswordException;
import com.qiushuang.seckill.param.LoginParam;
import com.qiushuang.seckill.service.LoginService;
import com.qiushuang.seckill.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/25 18:52
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserDao userDao;


    @Override
    public String login(String userId, String password) throws Exception {
        LoginParam param=userDao.getLoginParam(userId);
        if(password.equals(param.password)){
            String token=UUID.randomUUID().toString();
            redisService.setStr(userId,token);
            redisService.expire(userId,24*60*60);
//            LOGGER.info(userId+"_"+token);
            return token;
        }else{
            throw new WrongUserNameOrPasswordException();
        }
    }
}
