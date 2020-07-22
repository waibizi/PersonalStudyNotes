package edu.zqu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 歪鼻子
 * @Date 2020/7/22 17:46
 * @Description:
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jiangfeixiang.mpdemo.springbootmp.mapper")
public class MpdemoApplication {
    /**
     * 分页插件
     */
    public static void main(String[] args) {
        SpringApplication.run(MpdemoApplication.class, args);
    }
}
