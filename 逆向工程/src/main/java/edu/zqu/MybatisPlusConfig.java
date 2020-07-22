package edu.zqu;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author 歪鼻子
 * @Date 2020/7/22 17:45
 * @Description:
 * @Version 1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.jiangfeixiang.mpdemo.springbootmp.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
