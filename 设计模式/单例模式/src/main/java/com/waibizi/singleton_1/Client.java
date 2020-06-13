package com.waibizi.singleton_1;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 13:27
 * @Description:
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        SessionFactory factory_1 = SessionFactory.getInstance();
        SessionFactory factory_2 = SessionFactory.getInstance();
        //证明两个实例化创建的SessionFactory是同一个实例
        System.out.println(factory_1.hashCode()==factory_2.hashCode());
        //实验采用创建的实例去调用实例当中的方法
        factory_1.method();
    }
}
