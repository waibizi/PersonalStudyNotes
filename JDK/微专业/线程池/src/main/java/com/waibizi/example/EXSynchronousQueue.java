package com.waibizi.example;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 歪鼻子
 * @Date 2020/6/28 9:54
 * @Description:
 * @Version 1.0
 */
public class EXSynchronousQueue {
    public static void main(String[] args) {
        /* 主要是理解这个无缓冲等待队列，公平排队或者非公平排队而已 */
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,
                        new SynchronousQueue<>(true), Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());
        /* 提交二十个任务 */
        for (int i = 1; i<=20; i++){
            threadPoolExecutor.submit(()->{
                try {
                    System.out.println("开始执行");
                    Thread.sleep(1000L);
                    System.out.println("结束");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            System.out.println("任务"+i+"提交成功!!!!");
        }
    }
}
