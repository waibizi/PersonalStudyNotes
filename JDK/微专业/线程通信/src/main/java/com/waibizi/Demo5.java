package com.waibizi;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author 吴典秋
 * @Date 2020/5/28 12:34
 * @Description:
 * @Version 1.0
 */

public class Demo5 {
    private static Object TeaMilk = null;
    /** 正常的park/unpark**/
    public void parkUnpark() throws Exception{
        Thread consumerThread =  new Thread(()->{
            if (TeaMilk==null){ //如果没线程了，则进入等待
                System.out.println("没奶茶");

                synchronized (this){
                    LockSupport.park();  //等待许可
                }
            }
            System.out.println("有奶茶了啦");
        });
        consumerThread.start();
        //3秒之后，生产一个包子
        Thread.sleep(300L);
        TeaMilk = new Object();
        //对consumerThread颁发许可
       synchronized (this){
           LockSupport.unpark(consumerThread);
       }
        System.out.println("通知消费者");
    }

    public static void main(String[] args) throws Exception {
        new Demo5().parkUnpark();
    }
}
