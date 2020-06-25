package com.waibizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 歪鼻子
 * @Date 2020/6/25 0:52
 * @Description:
 * @Version 1.0
 */
@EnableZuulProxy //开启zuul的功能
@EnableEurekaClient
@SpringBootApplication
public class ZuulGateway {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway.class,args);
    }
}
