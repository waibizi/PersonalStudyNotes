package com.waibizi.singleton_5;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 16:54
 * @Description: 双重检查
 * @Version 1.0
 */
public class SessionFactory {
    //使用volatile可以让被此关键字修饰的变量一旦被修改就立即同步到主内存当中
    private static volatile SessionFactory instance;
    private SessionFactory(){

    }
    public static SessionFactory getInstance() throws InterruptedException {
        if (instance == null){
            Thread.sleep(3000L);
            synchronized (SessionFactory.class){
                if (instance == null){
                    instance = new SessionFactory();
                }
            }
        }
        return instance;
    }
}
