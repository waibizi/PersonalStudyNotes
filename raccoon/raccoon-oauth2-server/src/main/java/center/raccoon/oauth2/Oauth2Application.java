package center.raccoon.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author 歪鼻子
 * @Date 2020/7/4 17:35
 * @Description: 由于Spring Security的作者认为Oauth2不应该在Spring Security当中实现，所以项目有些注解被划了横线
 *               目前并不影响使用，如果后续有更好的策略可以替代,会更改这部分;
 * @Version 1.0
 */
@SpringBootApplication
@EnableAuthorizationServer
@MapperScan("center.raccoon.oauth2.project.mapper")
public class Oauth2Application {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class,args);
    }
}
