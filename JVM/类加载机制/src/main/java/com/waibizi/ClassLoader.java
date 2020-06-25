package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/24 16:58
 * @Description:
 * @Version 1.0
 */
public class ClassLoader {
    public static void main(String[] args) {
        String[] waibizi = {"歪鼻子"};
        System.out.println(waibizi.getClass().getClassLoader());

        ClassLoader[] classLoader = new ClassLoader[2];
        System.out.println(classLoader.getClass().getClassLoader());
    }
}
