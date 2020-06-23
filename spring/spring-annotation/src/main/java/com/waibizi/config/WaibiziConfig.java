package com.waibizi.config;
import org.springframework.web.context.WebApplicationContext;
import com.waibizi.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author 歪鼻子
 * @Date 2020/6/22 22:57
 * @Description:
 * @Version 1.0
 */
@Configuration   //告诉Spring这是一个Spring配置类
@ComponentScan(value = "com.waibizi.bean")
public class WaibiziConfig {

    //给同期注册一个Bean,类型为返回值类型
    @Bean(value = "person")
    @Scope("singleton")
    public Person person01(){
        return new Person();
    }


}
