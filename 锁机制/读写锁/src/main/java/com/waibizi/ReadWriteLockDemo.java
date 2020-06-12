package com.waibizi;

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
    //读操作
    public void get(){
        //加读锁
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"be ready to get data");
            Thread.sleep((long)(Math.random() * 1000));
            System.out.println(Thread.currentThread().getName()+"get the data"+data);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            //释放读锁
            rwLock.writeLock().unlock();
        }
    }

}
public class ReadWriteLockDemo {
    public static void main(String[] args) {

    }
}
