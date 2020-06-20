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
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void get(){//读操作
        rwLock.readLock().lock();//加读锁
        try {
            System.out.println(Thread.currentThread().getName() + " Get the data = " + data);
        }finally {
            rwLock.readLock().unlock();//释放读锁
        }
    }
    public void put(int data){//写操作
        rwLock.writeLock().lock();
        try {
            this.data = data;
            System.out.println(Thread.currentThread().getName()+" Start to write data ");
        }finally {
            rwLock.writeLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        DefQueue queue = new DefQueue();
        //启动线程在某一时刻进行进行写操作
        for (int i = 0;i < 100; i++){
            //启动线程进行读操作
            new Thread(queue::get).start();
            if (i == 4){
                new Thread(() -> {
                    queue.put(new Random().nextInt(10000));
                }).start();
            }
        }
    }
}
