package com.waibizi.singleton_6;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 17:31
 * @Description: 采用静态内部的方式设计单例
 * @Version 1.0
 */
public class SessionFactory {
    private static volatile SessionFactory instance;

    //构造器私有化
    private SessionFactory(){};
    //静态内部类只有在该类被调用的时候，才会执行
    private static class SessionFactoryInstance{
        private static final SessionFactory INSTANCE = new SessionFactory();
    }

    //提供一个静态的公有方法，直接返回SessionFactoryInstance.INSTANCE
    public static SessionFactory getInstance(){
        return SessionFactoryInstance.INSTANCE;
    }
}
