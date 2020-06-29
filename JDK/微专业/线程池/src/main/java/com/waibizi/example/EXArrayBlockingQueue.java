package com.waibizi.example;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 歪鼻子
 * @Date 2020/6/28 0:53
 * @Description:
 * @Version 1.0
 */
public class EXArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        /* 核心线程5，最大线程数10，空闲线程生存时间5秒，数组的阻塞队列，默认的线程工厂，默认的线程池拒绝策略 */
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());
        /* 提交二十个任务 */
        for (int i = 1; i <= 20; i++){
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
