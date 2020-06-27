package com.waibizi.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 歪鼻子
 * @Date 2020/6/26 22:03
 * @Description:
 * @Version 1.0
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
