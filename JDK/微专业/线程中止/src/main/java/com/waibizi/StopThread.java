package com.waibizi;

/**
 * @Author 吴典秋
 * @Date 2020/5/27 15:36
 * @Description:
 * @Version 1.0
 */

public class StopThread extends Thread{
    private int i=0,j=0;
    @Override
    public void run() {
        synchronized (this) {
            //增加同步锁
            ++i;
            try{
                //休眠10秒，模拟耗时操作
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            ++j;
        }
    }

    //打印i和j
    public void print(){
        System.out.println("i="+i+"j="+j);
    }
}
