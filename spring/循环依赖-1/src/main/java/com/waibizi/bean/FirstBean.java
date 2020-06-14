package com.waibizi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 21:37
 * @Description:
 * @Version 1.0
 */
@Component(value = "FirstBean")
public class FirstBean {
    public FirstBean() {
        System.out.println("FirstBean Construction");
    }

    @Autowired
    private SecondBean secondBean;

    public void method(){
        System.out.println("I'm first Bean");
    }

    public void toInvokeOtherBean(){
        secondBean.method();
    }
}
