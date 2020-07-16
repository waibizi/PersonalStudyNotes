package com.waibizi.self;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 1:44
 * @Description:
 * @Version 1.0
 */
public class AObserver implements Observer{
    private String name;
    public void update(String name) {
        this.name = name;
        display();
    }
    public void display(){
        System.out.println("===A  班 ===");
        System.out.println("本次巡查的老师是"+name);
    }
}
