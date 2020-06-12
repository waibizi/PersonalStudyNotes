package com.waibizi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 22:14
 * @Description: 公平锁
 * @Version 1.0
 */
public class FairLock {
    public static void main(String[] args) throws InterruptedException {
        method(true);
    }
    public static void method(boolean fair) throws InterruptedException{
        ReentrantLock lock = new ReentrantLock(fair);
        Thread thread = new Thread(()->{
           lock.lock();
           try {
               System.out.println("start");
               TimeUnit.SECONDS.sleep(1);
               new Thread(()->{
                    option(lock,"内部线程");
               }).start();
               System.out.println("end");
           }catch (InterruptedException e){
               e.printStackTrace();
           }finally {
               lock.unlock();
           }
        });
        thread.setName("thread");
        thread.start();
        option(lock,"外部线程");
    }
    public static void option(ReentrantLock lock,String threadName){
        for (int i = 0;i < 10; i++){
            Thread thread = new Thread(()->{
               lock.lock();
               try {
                   System.out.println(Thread.currentThread().getName()+"获取到锁");
               }finally {
                   lock.unlock();
                   System.out.println(Thread.currentThread().getName()+"释放锁");
               }
            });
            thread.setName(threadName+"-"+i);
            thread.start();
        }
    }
}
