package com.waibizi.config;

import com.waibizi.service.SingleService;
import com.waibizi.service.SpringCacheService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 16:32
 * @Description:
 * @Version 1.0
 */
@Configuration
public class AppConfig {

    @Bean
    public SingleService getSingleService(){
        return new SingleService();
    }
    @Bean
    public SpringCacheService getSpringCacheService(){
        return new SpringCacheService();
    }
}
