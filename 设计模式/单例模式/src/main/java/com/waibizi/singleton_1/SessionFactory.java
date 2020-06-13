package com.waibizi.singleton_1;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 13:08
 * @Description: 单例设计模式 饿汉式:类似Hibernate当中，SessionFactory就是采用了单例的设计模式
 *               通常在一个常见的需要工厂设计模式的时候，对于工厂本体一般是属于单例的，不用去new一个工程
 *               而是直接调用工程的instance方法去创建工厂，然后由工厂去生产一些类(因为工厂往往是比较重量级的)
 * @Version 1.0
 */
public class SessionFactory {

    //将构造器私有化，防止别的类对此进行new操作
    private SessionFactory(){

    }
    //本类内部创建对象实例
    private final static SessionFactory instance = new SessionFactory();

    public static SessionFactory getInstance(){
        return instance;
    }

    //一个测试方法
    public void method(){
        System.out.println("采用SessionFactory去生产东西");
    }

}
