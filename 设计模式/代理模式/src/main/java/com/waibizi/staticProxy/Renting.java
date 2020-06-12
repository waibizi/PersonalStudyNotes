package com.waibizi.staticProxy;

/**
 * @Author 歪鼻子
 * @Date 2020/5/30 0:20
 * @Description:
 * @Version 1.0
 */

public class Renting implements IRenting{

    @Override
    public void rent() {
        System.out.println("我是房东，有人来租房");
    }
}
