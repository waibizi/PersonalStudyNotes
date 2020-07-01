package com.waibizi;

import com.waibizi.dynamic.ArrayList;

/**
 * @Author 歪鼻子
 * @Date 2020/6/30 17:04
 * @Description:
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(13);
        System.out.println(list.toString());
        list.set(2,99);
        System.out.println(list.toString());
        list.add(3,100);
        System.out.println(list.toString());
        System.out.println(list.indexOf(100));
    }
}
