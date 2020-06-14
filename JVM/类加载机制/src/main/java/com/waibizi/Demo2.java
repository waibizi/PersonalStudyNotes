package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 20:58
 * @Description:
 * @Version 1.0
 */
class parent{
    static {
        System.out.println("parent initialization");
    }
    public static int val = 100;
}
class children extends parent{
    static {
        System.out.println("children initialization");
    }
}
/*
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(children.val);
    }
}
*/
public class Demo2 {
    public static void main(String[] args) {
        parent[] p = new parent[10];
    }
}
