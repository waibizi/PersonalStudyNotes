package com.waibizi.demo01;

import java.sql.SQLOutput;
import java.util.function.Supplier;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/5/5 2:14
 */
interface demo<T>{
    T get();
}
class Student{

}
public class demo01 {

    public static <T> T factory(Supplier<T> supplier){
        return supplier.get();
    }

    public demo01() {
    }

    public static void main(String[] args) {
        Supplier<Integer> supplier = ()-> 312312;
        System.out.println(supplier.get());
        String testString = "Student";
        Student student = factory(Student::new);
    }
}
