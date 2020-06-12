package com.waibizi.test1;

import java.util.function.Function;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/5/3 18:18
 */
@SuppressWarnings("all")



public class demo02 {
    public static int andThentest(int a,Function<Integer,Integer> function1,
                                  Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);

    }
    public static int composetest(int a,Function<Integer,Integer> function1,
                                  Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }
    public static void main(String[] args) {
        System.out.println(composetest(4, value -> value * 2, value -> value * value));
    }



//            System.out.println(andThentest(4, (value1) -> value1 * 2,
//            (value1) -> value1 * value1));
}
