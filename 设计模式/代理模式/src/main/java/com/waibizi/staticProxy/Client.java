package com.waibizi.staticProxy;
/**
 * @Author 歪鼻子
 * @Date 2020/5/30 0:20
 * @Description:
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 创建目标对象（被代理的对象）
         */
        IRenting target = new Renting();
        /**
         * 创建代理对象
         */
        RentingProxy proxy = new RentingProxy(target);
        /**
         * 使用代理对象执行方法
         */
        proxy.rent();
    }
}
