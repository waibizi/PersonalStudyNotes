package com.waibizi.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author 歪鼻子
 * @Date 2020/6/22 22:58
 * @Description:
 * @Version 1.0
 */
@Getter
@Setter
public class Person {

    @Value("歪鼻子")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {
        System.out.println("Person类被创建对象");
    }
}
