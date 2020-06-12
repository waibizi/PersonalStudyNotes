package com.waibizi;

/**
 * @Author 吴典秋
 * @Date 2020/5/27 22:57
 * @Description:
 * @Version 1.0
 */

public class Demo4 {
    private static Object TeaMilk = null;
    /** 错误的wait/notify */
    public void waitNotify() throws Exception {
        // 启动线程
        new Thread(() -> {
            if (TeaMilk==null){
                try { System.out.println("没奶茶");
                    Thread.sleep(5000L);
                }catch (InterruptedException e){ e.printStackTrace(); }
                synchronized (this){
                    try {
                        this.wait();//进入等待
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
        synchronized (this){ this.notifyAll(); }  //不在同个对象锁下会抛出异常
        System.out.println("通知消费者");
    }
    public static void main(String[] args) throws Exception {
        new Demo4().waitNotify();
    }
}

