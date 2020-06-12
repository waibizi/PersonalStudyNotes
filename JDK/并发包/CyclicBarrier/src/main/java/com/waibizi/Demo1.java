package com.waibizi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author 吴典秋
 * @Date 2020/6/5 2:00
 * @Description: 不加CyclicBarrier
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        for (int i = 0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"开始写入数据");
                try {
                    //模拟写入数据的耗时
                    Thread.sleep(30);
                    System.out.println(Thread.currentThread().getName()+"写入数据成功");
                    //我想要所有的线程都执行完上面的操作之后，再调用以下的方法
                    System.out.println(Thread.currentThread().getName()+"所有数据操作执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
