package com.waibizi.singleton_2;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 13:58
 * @Description:
 * @Version 1.0
 */
public class SessionFactory {
    //将构造器私有化，防止别的类对此进行new操作
    private SessionFactory(){

    }
    //本类内部创建对象实例
    private static SessionFactory instance ;

    static {
        instance = new SessionFactory();
    }

    public static SessionFactory getInstance(){
        return instance;
    }

    //一个测试方法
    public void method(){
        System.out.println("采用SessionFactory去生产东西");
    }
}
