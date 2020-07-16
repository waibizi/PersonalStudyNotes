package com.waibizi.cglibProxy;

import java.util.Objects;

/**
 * @Author 歪鼻子
 * @Date 2020/7/16 11:07
 * @Description:
 * @Version 1.0
 */
public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


}
class Test{
    public static void main(String[] args) {
        Person p1 = new Person("歪鼻子",123);
        Person p2 = new Person("歪鼻子",123);
        System.out.println(p1 == p2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
    }
}