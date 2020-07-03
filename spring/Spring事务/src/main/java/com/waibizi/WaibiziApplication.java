package com.waibizi;

import com.waibizi.service.RentingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 14:41
 * @Description:
 * @Version 1.0
 */
public class WaibiziApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        //rentingServiceImpl的bean
        RentingService rentingService = (RentingService) applicationContext.getBean("rentingServiceImpl");
        rentingService.rent();
    }
}
