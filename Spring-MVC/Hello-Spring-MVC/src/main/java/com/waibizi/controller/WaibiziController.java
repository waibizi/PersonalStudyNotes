package com.waibizi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 歪鼻子
 * @Date 2020/6/20 18:25
 * @Description:
 * @Version 1.0
 */
@Controller
@RequestMapping("/waibizi")
public class WaibiziController {
    @ResponseBody
    @RequestMapping("/mvc")
    public String waibizi() {
        System.out.println("waibizi come in");
        return "success";
    }
    /*转发，会转发request对象，简单理解就是转发的话，session有效*/
    @RequestMapping("/forward")
    public String forward(){
        System.out.println("我是forward");
        return "forward:/waibizi/mvc";
    }
    /*重定向，不会传递request对象，简单理解就是重定向的话，session无效*/
    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("我是forward");
        return "redirect:/waibizi/mvc";
    }
}
