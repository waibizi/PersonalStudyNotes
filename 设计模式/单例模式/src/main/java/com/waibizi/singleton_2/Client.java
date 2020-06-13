package com.waibizi.singleton_2;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 13:58
 * @Description:
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        SessionFactory factory_1 = SessionFactory.getInstance();
        SessionFactory factory_2 = SessionFactory.getInstance();
        System.out.println(factory_1.hashCode() == factory_2.hashCode());
        factory_1.method();
    }
}
