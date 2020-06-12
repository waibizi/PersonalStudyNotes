package com.waibizi.cglibProxy;



/**
 * @Author 吴典秋
 * @Date 2020/5/30 2:38
 * @Description:
 * @Version 1.0
 */

public class Client {
    public static void main(String[] args) {
        /**
         * 创建目标对象（被代理的对象）
         */
        Renting target = new Renting();
        /**
         * 获取到代理对象，并且将目标对象传递给代理对象
         */
        Renting proxyInstance = (Renting)new ProxyFactory(target).getProxyInstance();
        /**
         * 执行代理对象的方法，触发intecept方法，从而实现对目标对象的调用
         */
        proxyInstance.rent();
    }
}
