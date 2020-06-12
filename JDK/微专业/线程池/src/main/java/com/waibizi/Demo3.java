package com.waibizi;

import java.util.concurrent.*;

/**
 * @Author 吴典秋
 * @Date 2020/6/2 20:33
 * @Description: 线程池测试
 * @Version 1.0
 */
public class Demo3 {
    /**
     * 提交15个执行事件需要3秒的任务，查看线程池的状况
     */
    public void testCommon(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException {
        for (int i = 0;i<15;i++){
            int n = i ;
            threadPoolExecutor.submit(()->{
                try {
                    System.out.println("开始执行");
                    Thread.sleep(3000L);
                    System.out.println("结束执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("任务提交成功："+i+1);
        }
        // 查看线程数量，查看队列等待数量
        Thread.sleep(500L);
        System.out.println("当前线程池线程数量为："+threadPoolExecutor.getPoolSize());
        System.out.println("当前线程池线程等待的数量为："+threadPoolExecutor.getQueue().size());
        // 等待15秒，查看线程数量和队列数量（讲道理超出了核心线程数量的线程会被自动销毁）
        Thread.sleep(15000L);
        System.out.println("当前线程池线程数量为："+threadPoolExecutor.getPoolSize());
        System.out.println("当前线程池线程等待的数量为："+threadPoolExecutor.getQueue().size());
    }

    private void threadPoolExecutorTest1() throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(),
                (r,executor)->{
                    System.out.println("有任务被拒绝了");
                });
        testCommon(threadPoolExecutor);
    }
    private void threadPoolExecutorTest2() throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new
                ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(),
                (r,executor)->{
                    System.out.println("有任务被拒绝了");
                });
        testCommon(threadPoolExecutor);
    }

    public static void main(String[] args) throws Exception {
//        new Demo3().threadPoolExecutorTest1();
        new Demo3().threadPoolExecutorTest2();
    }
}
