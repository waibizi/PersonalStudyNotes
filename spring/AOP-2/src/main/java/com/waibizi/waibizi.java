package com.waibizi;

import com.waibizi.service.RentingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 歪鼻子
 * @Date 2020/5/30 20:26
 * @Description:
 * @Version 1.0
 */

public class waibizi {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        //rentingServiceImpl的bean
        RentingService rentingService = (RentingService) applicationContext.getBean("rentingServiceImpl");
        rentingService.rent();
    }
}
