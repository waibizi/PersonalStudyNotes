package com.waibizi.demo01;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class demo01 {
    public static void main(String[] args) {
        Student student1 = new Student("张三",10);
        Student student2 = new Student("王五",15);
        Student student3 = new Student("李四",50);
        List<Student> students = Arrays.asList(student1,student2,student3);

    }
}
