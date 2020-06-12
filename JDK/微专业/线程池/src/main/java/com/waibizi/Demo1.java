package com.waibizi;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @Author 歪鼻子
 * @Date 2020/6/2 14:20
 * @Description:
 * @Version 1.0
 */

public class Demo1 {
        public static void main(String[] args) {
            //创建固定数目的线程池
            ExecutorService executorService1 = Executors.newFixedThreadPool(5);
            //创建单个线程池，池中只有一个线程
            ExecutorService executorService2 = Executors.newSingleThreadExecutor();
            //创建一个具有缓存的线程池
            ExecutorService executorService3 = Executors.newCachedThreadPool();
            //创建一个股抵不过大小的线程池，可以延迟或定时执行任务
            ExecutorService executorService4 = Executors.newScheduledThreadPool(5);
            


    }
}
