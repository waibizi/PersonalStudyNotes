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
}
