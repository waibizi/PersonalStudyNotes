package com.waibizi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap的一些相关------JDK1.7
 * HashMap底层是将key进行hashcode的转换，然后将hashcode进行求余运算，然后变成一个数组的下标位置，如果有
 * 一次的hashcode下标运算一致了，那么在jdk1.7的时候是采用链表的方式往下接，插入的方法是头插法
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/27 22:28
 */
public class demo01 {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<String, String>();  //数组+链表
        hashMap.put("123","吴典秋");
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        System.out.println(hashMap.get("123"));
        System.out.println(Integer.highestOneBit(1));//101----->100
        System.out.println(Integer.bitCount(11));
        System.out.println(15&16);

        List<User> list = new ArrayList<>();
        list.add(new User(1,"吴典秋"));
        list.add(new User(2,"哈哈"));
        for (User u:
             list) {
            u.setName("不是不是");
        }

        System.out.println(list.toString());
    }
}
