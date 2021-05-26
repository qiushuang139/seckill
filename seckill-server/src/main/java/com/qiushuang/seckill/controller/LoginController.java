package com.qiushuang.seckill.controller;

import com.qiushuang.seckill.controller.api.CommonResult;
import com.qiushuang.seckill.exception.WrongUserNameOrPasswordException;
import com.qiushuang.seckill.param.LoginParam;
import com.qiushuang.seckill.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Api(tags = "LoginController",description = "登录管理")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public CommonResult login(@RequestBody LoginParam param){
        try {
            String token=loginService.login(param.userId, param.password);
            return CommonResult.success(token);
        }catch (WrongUserNameOrPasswordException ex){
            return CommonResult.failed("密码错误");
        }catch (Exception ex){
            return CommonResult.failed();
        }
    }
}
