package com.waibizi;

import java.util.concurrent.Semaphore;

/**
 * @Author 吴典秋
 * @Date 2020/6/5 11:50
 * @Description: Semaphore是一种基于计数的信号量，它可以设定一个阈值，基于这个，多个线程可以竞争获取许可信号，
 * 线程做完后归还，超过阈值后，线程申请许可信号将会被阻塞。Semaphore可以用来构建一些对象池，资源池之类的，比如数据库连接池，可以创建计数
 * 为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示互斥的状态
 * 需求：一个厕所只有三个坑位，但是有10个人来上厕所，咋办？假设10个人的编号分别为1-10，并且一号先到厕所，10号最后到厕所。那么1-3来到的时候
 * 必定会有厕所可以上，顺利如厕，4号来的时候需要看看前面三人是否有人出来了，如果有人出来了，就进去，否则就等待~，以此类推；
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        //声明资源
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0;i<10;i++){
            new Thread(()->{
                //获取到资源，减去1
                int availablePermits = semaphore.availablePermits();
                if (availablePermits>0){
                    System.out.println(availablePermits);
                    System.out.println(Thread.currentThread().getName()+"收到的通知：奶茶店有位置啦~~~~~");
                }else {
                    System.out.println(Thread.currentThread().getName()+"收到的通知：奶茶店没位置哦~~~~~");
                }
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"开始喝奶茶啦~");
                    //模拟和奶茶的场景
                    Thread.sleep(5000L);
                    System.out.println(Thread.currentThread().getName()+"喝完奶茶啦");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
