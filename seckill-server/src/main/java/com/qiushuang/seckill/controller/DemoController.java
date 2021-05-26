package com.qiushuang.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :zhangyi
 * @description:
 * @date :2021/4/15 10:49
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","qiushuang");
        return "hello";
    }

}
