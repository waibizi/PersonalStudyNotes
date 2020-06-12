package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 20:58
 * @Description: 这个demo有点问题，暂时搁一边
 * @Version 1.0
 */
public class InstructRearrang {
    static int x = 0, y = 0;
    static int a = 0, b = 0;
    //启动两个线程去修改主线程当中的值，可以看到两个线程对于值的修改是乱序的
    public static void main(String[] args) throws InterruptedException {

        Thread thread_1 =new Thread(()->{
           a = 1;
           x = b;
        });

        Thread thread_2 = new Thread(()->{
           b = 1;
           y = a;
        });

        thread_1.start();
        thread_2.start();
        //保证主线程必须在这两个线程执行完成之后才能执行
        thread_1.join();  thread_2.join();
        System.out.println("("+x+","+y+")");
    }
}
