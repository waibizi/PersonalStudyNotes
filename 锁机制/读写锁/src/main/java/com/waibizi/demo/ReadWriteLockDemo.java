package com.waibizi.demo;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author 歪鼻子
 * @Date 2020/6/12 1:10
 * @Description:
 * @Version 1.0
 */
class DefQueue{
    private int data;
    ReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    public void get(){//读操作
        rwLock.readLock().lock();//加读锁
        try {
            System.out.println(Thread.currentThread().getName()+" Be ready to get data");
            Thread.sleep((long)(Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " Get the data = " + data);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();//释放读锁
        }
    }
    public void put(int data){//写操作
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" Be ready to write data");
            Thread.sleep((long)(Math.random() * 1000));
            this.data = data;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        DefQueue queue = new DefQueue();
        for (int i = 0;i < 10; i++){
            //启动线程进行读操作
            new Thread(() -> {
                while (true){
                    queue.get();
                }
            }).start();
            //启动线程进行写操作
            new Thread(() -> {
                while (true){
                    queue.put(new Random().nextInt(10000));
                }
            }).start();
        }
    }
}
