package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 17:29
 * @Description:
 * @Version 1.0
 */
public class Demo1 {
    public volatile  int inc = 0;
    public void increase(){
        inc++;
    }

    public static void main(String[] args) {
        Demo1 d = new Demo1();
        for (int i =0;i<10;i++){
            new Thread(()->{
               for (int j = 0;j < 10;j++){
                   d.increase();
               }
            }).start();
        }
        //如果当前进程的线程数大于1的话，就让下面方法的所在的线程暂停，等待其他线程完成操作
       while (Thread.activeCount()>1){
           Thread.yield();
       }
        System.out.println(d.inc);
    }
}
