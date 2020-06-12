package com.waibizi;

import java.util.concurrent.CountDownLatch;

/**
 * @Author 吴典秋
 * @Date 2020/6/5 0:41
 * @Description: 不加countDownLatch线程乱序执行（其实就是因为看哪个线程谁先抢到CPU的执行权，就有办法执行·）
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("我是主线程开始执行任务");
        /**
         * 开启第一个新线程
         */
        new Thread(()->{
            System.out.println("我是子线程一开始执行任务");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程一继续执行任务");
        }).start();
        /**
         * 开启第二个新线程
         */
        new Thread(()->{
            System.out.println("我是子线程二开始执行任务");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程二继续执行任务");
        }).start();
        System.out.println("我是主线程继续执行任务");
    }
}
