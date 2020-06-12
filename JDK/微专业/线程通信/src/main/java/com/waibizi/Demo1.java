package com.waibizi;

/**
 * @Author 吴典秋
 * @Date 2020/5/27 21:56
 * @Description:
 * @Version 1.0
 */
public class Demo1 {
    private static Object TeaMilk = null;
    public void suspendResume() throws Exception{
        //启动线程
        Thread consumerThread = new Thread(()->{
            if (TeaMilk==null){ //如果没有包子就进入等待状态
                System.out.println("没奶茶");
                //当前线程拿到锁，然后挂起
                synchronized (this){
                    Thread.currentThread().suspend();
                }
            }
            System.out.println("有奶茶了啦");
        });
        consumerThread.start();
        //三秒之后，生产一杯奶茶
        Thread.sleep(3000L);
        TeaMilk = new Object();
        //竞争当前对象的锁，再恢复consumerThread
        synchronized (this){
            consumerThread.resume();
        }
        System.out.println("通知消费者");
    }
    public static void main(String[] args) throws Exception {
        new Demo1().suspendResume();
    }
}
