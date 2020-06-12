package com.waibizi;

/**
 * @Author 吴典秋
 * @Date 2020/5/27 22:34
 * @Description:
 * @Version 1.0
 */

public class Demo3 {
    private static Object TeaMilk = null;
    /** 正常的wait/notify */
    public void waitNotify() throws Exception {
        // 启动线程
        new Thread(() -> {
            synchronized (this) {
                while (TeaMilk == null) { // 如果奶茶，则进入等待
                    try {
                        System.out.println("没奶茶");
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("有奶茶了啦");
        }).start();
        // 3秒之后，生产一杯奶茶
        Thread.sleep(3000L);
        TeaMilk = new Object();
        synchronized (this) {
            this.notifyAll();
            System.out.println("通知消费者");
        }
    }
    public static void main(String[] args) throws Exception {
        new Demo3().waitNotify();
    }
}
