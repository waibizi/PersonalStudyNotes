package com.waibizi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author 吴典秋
 * @Date 2020/6/5 2:20
 * @Description:
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"开始写入数据");
                try {
                    //模拟写入数据的耗时
                    Thread.sleep(30);
                    System.out.println(Thread.currentThread().getName()+"写入数据成功");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"所有数据操作执行完毕");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
