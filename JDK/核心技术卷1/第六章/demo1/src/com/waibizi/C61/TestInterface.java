package com.waibizi.C61;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/30 9:59
 */
public class TestInterface {


    public void Test(MyInterface myInterface){
        myInterface.print();
    }
}
class Test{
    public static void main(String[] args) {
        new TestInterface().Test(System.out::println);

        List<String> list = new ArrayList<>();
        list.forEach(System.out::println);
    }
}