package com.waibizi.singleton_4;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 16:34
 * @Description: 这种方式虽然解决了线程安全的问题了，但是效率太低了，我们只有在最开始的时候进行实例化才有这种情况的使用，如果后面后多线程需要进行获该类的实例
 *               的话，都会进行排队等待。
 * @Version 1.0
 */
public class SessionFactory {
    private static SessionFactory instance;

    private SessionFactory(){

    }
    //提供一个静态的公有方法，当使用到该方法时，才去创建instance
    //懒汉式
    //这里是线程安全的，我们需要加入同步处理的手段，这个例子采用同步方法的方式
    public static synchronized SessionFactory getInstance() throws InterruptedException {
        if (instance == null){
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
