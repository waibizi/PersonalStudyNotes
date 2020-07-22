package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/7/22 9:59
 * @Description:
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(123);
        stack.push(456);
        stack.push(789);
        stack.push(888);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        Integer i = 128;
        Integer j = 128;
        System.out.println(i == j);
        Integer m = new Integer(99);
        Integer n = new Integer(99);
        System.out.println(m == n);
    }
}
