package com.waibizi.annotation;
import java.lang.annotation.*;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 18:22
 * @Description:
 * @Version 1.0
 */
/* 元注解 */
@Target({ElementType.METHOD})
/* 描述注解的生命周期(被描述的注解在什么范围内有效) */
@Retention(RetentionPolicy.RUNTIME)
public @interface WaibiziTransactional {

}
