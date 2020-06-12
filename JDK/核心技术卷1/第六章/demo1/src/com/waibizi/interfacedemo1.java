package com.waibizi;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/20 15:25
 */
public class interfacedemo1 {

    public static void main(String[] args) {
//        List<Integer> list  = new ArrayList<Integer>();
//        Arrays.sort(new List[]{list});

//        List<String> list = Arrays.asList("我是","吴典秋");
//        list.forEach(System.out::println);
        interfacedemo1 test = new interfacedemo1();
        System.out.println(test.compute1(4,value->value*2,value->value*value));
        System.out.println(test.compute2(4,value->value*2,value->value*value));
        System.out.println(test.compute3(4,4,(value1,value2)->value1*2));
        System.out.println(test.compute4(4,4,(value1,value2)->value1*2,value->value*2));





    }

    public int compute1(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b,BiFunction<Integer,Integer,Integer> bifunction){
        return bifunction.apply(a,b);
    }

    public int compute4(int a, int b,BiFunction<Integer,Integer,Integer> bifunction1,
                        Function<Integer,Integer> function2){
        return bifunction1.andThen(function2).apply(a,b);
    }


}
