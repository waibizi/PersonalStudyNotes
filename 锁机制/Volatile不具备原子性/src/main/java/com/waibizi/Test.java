package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 20:43
 * @Description:
 * @Version 1.0
 */
public class Test {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }
    public static void main(String[] args) {
        final Test test = new Test();

        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                };
            }.start();
        }
        while (Thread.activeCount() > 1) //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}