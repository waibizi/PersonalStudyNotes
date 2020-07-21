package com.waibizi.双向链表;

import com.waibizi.双向链表.双向循环链表.DoubleCircleLinkedList;

/**
 * @Author 歪鼻子
 * @Date 2020/7/11 19:50
 * @Description:
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(123);
        System.out.println(list.toString());
        list.add(1,321);
        System.out.println(list.toString());
        System.out.println(list.indexOf(123));
        list.add(0,888);
        System.out.println(list.toString());

        System.out.println("----------分割线----------");

        DoubleCircleLinkedList<Integer> doubleCircleLinkedList = new DoubleCircleLinkedList<>();
        doubleCircleLinkedList.add(999);
        doubleCircleLinkedList.add(888);
        System.out.println(doubleCircleLinkedList.toString());
        doubleCircleLinkedList.remove(0);
        System.out.println(doubleCircleLinkedList.toString());

    }
}
