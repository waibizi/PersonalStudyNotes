package com.waibizi;

import com.waibizi.service.RentingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 13:35
 * @Description:
 * @Version 1.0
 */
public class WaibiziApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        RentingService rentingService = (RentingService) applicationContext.getBean("rentingServiceImpl");
        rentingService.rent();
    }

}
