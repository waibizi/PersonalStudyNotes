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
        Person person = ac.getBean(Person.class);
        System.out.println(person.toString());
        /* 找出Person在spring容器当中的类型 */
        String[] nameForType = ac.getBeanNamesForType(Person.class);
        for (String name:
             nameForType) {
            System.out.println(name);
        }

        Student student1 = (Student) ac.getBean("student");
        Student student2 = (Student) ac.getBean("student");
        System.out.println(student1 == student2);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student1.equals(student2));

    }
}
