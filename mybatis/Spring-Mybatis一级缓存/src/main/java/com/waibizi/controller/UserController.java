package com.waibizi.controller;

import com.waibizi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 歪鼻子
 * @Date 2020/6/26 22:31
 * @Description:
 * @Version 1.0
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/query.do")
    public void query(){
        userService.query();
    }

    @RequestMapping("/update.do")
    public void update(){
        userService.update();
    }
}
