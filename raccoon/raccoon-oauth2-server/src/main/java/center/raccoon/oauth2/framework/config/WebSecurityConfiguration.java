package center.raccoon.oauth2.framework.config;

import center.raccoon.oauth2.framework.filter.CaptchaFilter;
import center.raccoon.oauth2.framework.handler.RaccoonAuthenticationFailureHandler;
import center.raccoon.oauth2.framework.handler.RaccoonAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author 歪鼻子、xiaoxiong
 * @Date 2020/7/7 0:04
 * @Description:
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
@Order(1)
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    RaccoonUserDetailsService raccoonUserDetailsService;

    @Autowired
    RaccoonAuthenticationSuccessHandler raccoonAuthenticationSuccessHandler;

    @Autowired
    RaccoonAuthenticationFailureHandler raccoonAuthenticationFailureHandler;

    @Autowired
    CaptchaFilter captchaFilter;

    /**
     *配置安全拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().antMatchers("/login/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/raccoon/login").permitAll()
                .and()
                .authorizeRequests().antMatchers("/captcha").permitAll()
                .and()
                .authorizeRequests().antMatchers("/raccoon/captcha").permitAll()
                .and()
                .authorizeRequests().antMatchers("/kickOut","/redis").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
    }

    /**
     *配置用户信息服务
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(raccoonUserDetailsService);
    }

    /**
     *配置加盐方式
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
