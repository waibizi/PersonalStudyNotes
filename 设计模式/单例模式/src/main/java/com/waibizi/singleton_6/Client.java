package com.waibizi.singleton_6;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 21:06
 * @Description:
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        new Thread(()->{
           SessionFactory factory_1 = SessionFactory.getInstance();
            System.out.println(factory_1.hashCode());
        }).start();
        new Thread(()->{
            SessionFactory factory_2 = SessionFactory.getInstance();
            System.out.println(factory_2.hashCode());
        }).start();
    }
}
