package com.waibizi;

/**
 * @Author 吴典秋
 * @Date 2020/5/30 14:12
 * @Description:
 * @Version 1.0
 */

public class Demo1 {
    public static ThreadLocal<String> value = new ThreadLocal<String>();
    public void ThreadLocalTest() throws Exception{
        value.set("waibizi");
        System.out.println("主线程拿到的值:"+value.get());
        Thread thread = new Thread(()->{
            System.out.println("新创建的线程拿到的值"+value.get());
            value.set("aixuexi");
            System.out.println("新建了一个值之后拿到的值:"+value.get());
            System.out.println("新建线程执行完毕");
        });
        thread.start();
        //休眠三秒，然后新创建的线程与主线程的打印语句不要混乱
        Thread.sleep(3000L);
        System.out.println("主线程拿到的值:"+value.get());
    }

    public static void main(String[] args) throws Exception {
        new Demo1().ThreadLocalTest();
    }
}
