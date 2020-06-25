package com.waibizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 歪鼻子
 * @Date 2020/6/25 0:13
 * @Description:
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class A_ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(A_ServerApplication.class, args);
    }
}
