package com.waibizi.spin_1;
public class Demo1 {
    public static void main(String[] args) {
        for (int i =0;i < 5;i++){
            new Thread(()->{
                System.out.println("当前线程 = "+Thread.currentThread().getName()+"开始执行了");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程 = "+Thread.currentThread().getName()+"执行完毕了");
            }).start();
        }
        while (Thread.activeCount() != 1){

        }
        System.out.println("所有的线程执行完毕了");
    }
}