package com.waibizi;

import java.util.Optional;

/**
 * @Author 吴典秋
 * @Date 2020/6/4 1:23
 * @Description:
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        //构造一个空的Optional对象
        //Optional<String> optional0 = Optional.empty();
        //构造一个具有值的Optional对象，如果值为空，将直接抛出NullPointerException异常
        //Optional<String> optional1 =Optional.of(null);
        //构造一个在有值的情况下，就是一个有值的Optional，在没值的情况下就是一个空的Optional的对象
        Optional<String> optional2 =Optional.of("waibizi");
        optional2.ifPresent(System.out::println);
        //String result = optional2.orElse("aixuexi");
        Optional<String> optional = Optional.empty();
        String result = optional.orElseGet("waibizi"::toUpperCase);
        System.out.println(result);
        System.out.println("卧槽，好紧张");
    }
}
