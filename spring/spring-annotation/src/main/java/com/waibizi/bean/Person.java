package com.waibizi.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author 歪鼻子
 * @Date 2020/6/22 22:58
 * @Description:
 * @Version 1.0
 */
@Data
public class Person {

    //使用@Value赋值
    //1.基本数值

    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;
}
