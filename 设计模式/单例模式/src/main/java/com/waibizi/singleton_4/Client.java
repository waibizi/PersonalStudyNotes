package com.waibizi.singleton_4;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 16:38
 * @Description:
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        new Thread(()-> {
            try {
                SessionFactory factory_1 = SessionFactory.getInstance();
                System.out.println(factory_1.hashCode());
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
        }).start();
        new Thread(()->{
           try {
               SessionFactory factory_2 = SessionFactory.getInstance();
               System.out.println(factory_2.hashCode());
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }).start();
    }
}
