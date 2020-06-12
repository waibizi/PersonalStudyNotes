package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/11 16:10
 * @Description:
 * @Version 1.0
 */
class Data{
    int value = 0;
    public void setValue(){
        value = 100;
    }
}
public class Demo1 {
    public static void main(String[] args) {
       Data data = new Data();
       new Thread(()->{
           System.out.println(Thread.currentThread().getName()+"update value Thread join");
           try {
               //线程休眠三秒
               Thread.sleep(3000L);
           }catch (Exception e){
               e.printStackTrace();
           }
           data.setValue();
           System.out.println(Thread.currentThread().getName()+"update value success");
       }).start();

       while (data.value == 0){
           //空等待
           System.out.println("我在等待data的value修改");
       }
        System.out.println(Thread.currentThread().getName()+"GG");
    }

}
