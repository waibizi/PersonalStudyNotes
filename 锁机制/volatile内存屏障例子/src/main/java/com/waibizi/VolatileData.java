package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 17:00
 * @Description:
 * @Version 1.0
 */

public class VolatileData {
    private int x = 0;
    private volatile boolean condition = false;
    public void write(){
        x = 99;
        condition = true;
    }
    public void read(){
        System.out.println("condition = "+condition);
        System.out.println("x = "+99);
    }
}
