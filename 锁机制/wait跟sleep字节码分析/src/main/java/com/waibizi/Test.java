package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/7/21 10:22
 * @Description:
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object){
            //object.wait();
            Thread.sleep(1000L);
        }
    }
}
