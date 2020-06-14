package com.waibizi.singleton_3;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 14:07
 * @Description: 这个为什么说线程不安全呢，如果在初始化阶段，也就是还没进行实例化的时候，线程一进入if判断了，但是还没开始new，此时线程二也跟着进来了，就会导致线程二
 *               在if判断的时候，也会判断为空，然后两个就一起进行实例化了
 * @Version 1.0
 */
public class SessionFactory {

    private static SessionFactory instance;

    private SessionFactory(){

    }

    //提供一个静态的公有方法，当使用到该方法时，才去创建instance
    //懒汉式
    public static SessionFactory getInstance() throws InterruptedException {
        if (instance == null) {
            //模拟线程不安全导致问题，也就是两个线程都会进行实例化
            Thread.sleep(3000L);
            instance = new SessionFactory();
        }
        return instance;
    }

    //一个测试方法
    public void method(){
        System.out.println("采用SessionFactory去生产东西");
    }
}
