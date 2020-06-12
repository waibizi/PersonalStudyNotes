package com.waibizi.JdkProxy;

import java.lang.reflect.Proxy;

/**
 * @Author 吴典秋
 * @Date 2020/5/30 1:14
 * @Description:
 * @Version 1.0
 */

public class ProxyFactory {
    /**
     * 维护一个目标对象
     */
    private Object target;
    /**
     * 构造器，对target进行初始化
     */
    public ProxyFactory(Object target){
        this.target = target;
    }
    /**
     * 给目标对象生成一个代理对象
     * 1.ClassLoader loader:使用当前目标对象使用的类加载器，获取加载器的方法固定
     * 2.Class<?>[] interfaces：目标对象实现的接口类型，使用泛型方法确认类型
     * 3.InvocationHandler h：事件处理，执行目标对象的方法时，
     *   会触发事情处理器方法，会把当前执行的目标对象方法作为参数传入
     */
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy,method,args)->{
                    System.out.println("代理开始");
                    Object result = method.invoke(target,args);
                    System.out.println("代理结束");
                    return result;
                });
    }
}
