package com.qiushuang.seckill.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SeckillUser {
    private Long id;
    private Long phone;
    private String nickname;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
