package com.waibizi.test1;
import java.util.TreeSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;
/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/20 20:18
 */
public class Student implements Name,Person{

    @Override
    public String getName() {
        return Person.super.getName();
    }

    public static void main(String[] args) {
        System.out.println(new Student().getName());
    }
}
