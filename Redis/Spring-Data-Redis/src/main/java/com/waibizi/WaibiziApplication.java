package com.waibizi;

import com.waibizi.config.AppConfig;
import com.waibizi.config.RedisConfig;
import com.waibizi.service.SingleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 16:27
 * @Description:
 * @Version 1.0
 */
public class WaibiziApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(AppConfig.class);
        ac.register(RedisConfig.class);
        ac.refresh();
        SingleService singleService = (SingleService) ac.getBean(SingleService.class);
    }
}
