package com.waibizi;

import com.waibizi.bean.Person;
import com.waibizi.bean.Student;
import com.waibizi.config.WaibiziConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author 歪鼻子
 * @Date 2020/6/22 23:00
 * @Description:
 * @Version 1.0
 */
public class WaibiziApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(WaibiziConfig.class);
        Person person1 = ac.getBean(Person.class);
        Person person2 = ac.getBean(Person.class);
        System.out.println(person1 == person2);
    }
}
