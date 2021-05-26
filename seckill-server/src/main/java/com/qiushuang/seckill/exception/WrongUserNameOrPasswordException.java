package com.qiushuang.seckill.exception;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 10:59
 * @description：
 * @modified By：
 * @version:
 */
public class WrongUserNameOrPasswordException extends Exception{

    public WrongUserNameOrPasswordException(){

    }

    public WrongUserNameOrPasswordException(String message){
        super(message);
    }
}
