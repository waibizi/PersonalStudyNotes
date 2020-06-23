package com.waibizi.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author 歪鼻子
 * @Date 2020/6/22 23:47
 * @Description:
 * @Version 1.0
 */

@Component
@Scope("prototype")
public class Student {
    @Value("歪鼻子")
    private String name;

    @Value("学习笔记")
    private String note;


}
