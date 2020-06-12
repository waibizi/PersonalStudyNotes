package com.waibizi;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 吴典秋
 * @Date 2020/6/7 16:41
 * @Description:
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,10));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndAdd(10));


    }
}
