package com.waibizi;

/**
 * @Author 吴典秋
 * @Date 2020/5/27 15:36
 * @Description:
 * @Version 1.0
 */

public class Demo3 {
    public static void main(String[] args) throws InterruptedException{
        StopThread thread = new StopThread();
        thread.start();
        //休眠一秒，确保i变量自增成功
        thread.sleep(1000);
        //暂停线程
        thread.stop();  //错误的方式
        while (thread.isAlive()){
            //确保线程已经中止
        }//输出结果
        thread.print();
    }

}
