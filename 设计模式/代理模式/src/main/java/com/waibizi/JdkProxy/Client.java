package com.waibizi.JdkProxy;

import com.waibizi.staticProxy.IRenting;
import com.waibizi.staticProxy.Renting;

/**
 * @Author 吴典秋
 * @Date 2020/5/30 1:29
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
         * 给目标对象，创建代理对象
         */
        IRenting  proxyInstance = (IRenting)new ProxyFactory(target)
                                                .getProxyInstance();
        /**
         * 使用代理对象执行方法
         */
        proxyInstance.rent();
    }
}
