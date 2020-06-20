package com.waibizi.spin_1;
public class Demo {
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
        //由于我的编码工具我缘故，这里我使用了判断线程还剩下几个有了数字2，如果正常情况下应该是 1 ！
        while (Thread.activeCount() != 2){

        }
        System.out.println("所有的线程执行完毕了");
    }
}
