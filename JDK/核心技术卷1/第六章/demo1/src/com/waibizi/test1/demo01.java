package com.waibizi.test1;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/5/3 17:52
 */
public class demo01 {
    public static void main(String[] args) {
        String [] waibizi = new String[]{"爱生活爱技术","鼻子不歪","歪鼻子"};
        Arrays.sort(waibizi,(a, b)->a.length()-b.length());
        for (String s:
             waibizi) {
            System.out.println(s);
        }
    }
}
