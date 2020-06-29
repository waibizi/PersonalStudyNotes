package com.waibizi;


import java.util.List;
import java.util.concurrent.*;
/**
 * @Author 歪鼻子
 * @Date 2020/6/2 20:04
 * @Description:
 * @Version 1.0
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,
                                   new LinkedBlockingDeque<>(3),Executors.privilegedThreadFactory(),
                                   (r,executor)->{
                                   System.out.println("有任务被拒绝了");
                                   });
        for (int i = 0; i < 15; i++) {
            int n = i;
            //提交一个可运行任务以执行，并返回一个future对象，执行结果为null
            threadPoolExecutor.submit(()->{
                   try {
                       System.out.println("开始执行");
                       Thread.sleep(3000L);
                       System.out.println("结束");
                   }catch (InterruptedException e){
                       e.printStackTrace();
                   }
                }
            );
            System.out.println("任务提交成功 :" + i);
        }
        // 1秒后终止线程池
        Thread.sleep(1000L);
        //尝试停止正在执行的任务，停止等待的任务的处理，并返回等待执行任务的列表
        List<Runnable> shutdownNow = threadPoolExecutor.shutdownNow();
    }
}
