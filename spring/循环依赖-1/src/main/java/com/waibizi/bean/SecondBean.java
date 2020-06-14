package com.waibizi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 21:38
 * @Description:
 * @Version 1.0
 */
@Component(value = "SecondBean")
public class SecondBean {
    public SecondBean() {
        System.out.println("SecondBean Construction");
    }

    @Autowired
    FirstBean firstBean;

    public void method(){
        System.out.println("I'm second Bean");
    }

    public void toInvokeOtherBean(){
        firstBean.method();
    }
}
