package com.qiushuang.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author :zhangyi
 * @description:
 * @date :2021/4/15 15:37
 */
public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt="1a2b3c4d";

    public static String inputPassToFormPass(String inputPass){
        String str=salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass,String salt){
        String str=salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(salt);
    }

    public static String inputPassToDBPass(String inputPass,String salt){
        String formPass=inputPassToFormPass(inputPass);
        String dbPass=formPassToDBPass(formPass,salt);
        return dbPass;
    }

    public static void main(String[] args){
        String pass="12345678";
        System.out.println(MD5Util.inputPassToDBPass(pass,"12345678"));
    }
}
