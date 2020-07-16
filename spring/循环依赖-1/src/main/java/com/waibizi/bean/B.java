package com.waibizi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 14:02
 * @Description:
 * @Version 1.0
 */
@Service
public class B {
    @Autowired
    private A a;
}
