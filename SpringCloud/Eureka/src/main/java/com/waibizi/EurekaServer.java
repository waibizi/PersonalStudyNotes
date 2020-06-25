package com.waibizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author 歪鼻子
 * @Date 2020/6/24 23:57
 * @Description:
 * @Version 1.0
 */
@EnableEurekaServer // 标识它是Eureka服务器
@SpringBootApplication
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}
