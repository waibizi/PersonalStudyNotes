package com.waibizi;
/**
 * @Author 歪鼻子
 * @Date 2020/6/27 21:35
 * @Description:
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 500;i++){
            new Thread(()->{
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
