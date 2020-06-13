package com.waibizi.singleton_3;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 14:07
 * @Description: 懒汉式的单例模式
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            try {
                SessionFactory factory_1 = SessionFactory.getInstance();
                System.out.println(factory_1.hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                SessionFactory factory_2 = SessionFactory.getInstance();
                System.out.println(factory_2.hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



    }
}
