package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 21:36
 * @Description:
 * @Version 1.0
 */
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new Thread(()->{
            System.out.println("First task started");
            System.out.println("First task for sleeping for 2 seconds");
            try {
                Thread.sleep(2000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("First task completed");
        });
        Thread thread_2 = new Thread(()->{
            System.out.println("Second task completed");
        });
        thread_1.start();
        //加入join方法可以使用其他的线程必须等待线程1执行完成之后才可以执行其他线程，也就是除了线程1的之外的其他线程都会处于阻塞的状态

        thread_2.start();
        thread_1.join();
    }

}
