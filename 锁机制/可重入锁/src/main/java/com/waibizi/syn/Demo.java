package com.waibizi.syn;

/**
 * @Author 歪鼻子
 * @Date 2020/6/14 16:37
 * @Description:
 * @Version 1.0
 */
public class Demo {
    public static synchronized void method_1() throws InterruptedException {
        System.out.println("I'm method one");
        method_2();

    }
    public static synchronized void method_2() throws InterruptedException {
        System.out.println("I'm method two");
    }

    public static void main(String[] args) throws InterruptedException {
       method_1();
    }
}
