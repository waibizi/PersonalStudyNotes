package com.waibizi;

import java.util.concurrent.CountDownLatch;

/**
 * @Author 吴典秋
 * @Date 2020/6/5 0:53
 * @Description:
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        //声明我有两个“门栓”
        CountDownLatch countDownLatch = new CountDownLatch(2);
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
            //门栓数量减一
            countDownLatch.countDown();
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
            //门栓数量减一
            countDownLatch.countDown();
        }).start();
        //如果门栓数目还一直不为zero，那么就不会执行下面的代码了
        countDownLatch.await();
        System.out.println("我是主线程继续执行任务");
    }
}
