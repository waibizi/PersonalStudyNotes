package com.waibizi;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/18 23:31
 */
public class demo01 {
    public static void main(String[] args) {
        int size = 1024*1024;

        byte [] myAlloc1  = new byte[5*size];  //定义了两兆的空间
//        byte [] myAlloc2  = new byte[3*size];  //定义了两兆的空间
//        byte [] myAlloc3  = new byte[3*size];  //定义了两兆的空间
//        byte [] myAlloc4  = new byte[3*size];  //定义了两兆的空间
        try{
            Thread.sleep(1000000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("hello world");
    }
}
