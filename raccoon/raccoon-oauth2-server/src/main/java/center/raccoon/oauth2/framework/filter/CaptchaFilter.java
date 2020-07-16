package center.raccoon.oauth2.framework.filter;

import center.raccoon.oauth2.framework.exception.CaptchaException;
import center.raccoon.oauth2.framework.handler.RaccoonAuthenticationFailureHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author xiaoxiong
 * @Date2020/7/5 23:55
 * @Description:自定义验证码过滤器
 * @Version 1.0
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RaccoonAuthenticationFailureHandler raccoonAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //如果请求url是/raccoon/login，且请求方式是post的方式
        if(StringUtils.equals("/login",httpServletRequest.getRequestURI()) &&StringUtils.equalsIgnoreCase("post",httpServletRequest.getMethod())){
            try{
                /* 验证方法 */
                validate(httpServletRequest);
            }catch (AuthenticationException e){
                /* 验证谜底与用户输入的是否匹配 */
                raccoonAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                /* 出现异常终止程序 */
                return;
            }
        }
        /* 没有异常放行请求响应 */
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    /**
     * 验证码检验函数
     * @param request
     */
    private void validate(HttpServletRequest request){
        /* 从请求域中获取cToken和captcha */
        String cToken=request.getParameter("cToken");
        String captcha=request.getParameter("captcha");
        /* 如果两者中有一个为空抛自定义异常 */
        if(StringUtils.isEmpty(captcha)||StringUtils.isEmpty(cToken)){
            throw new CaptchaException("请填写验证码!");
        }
        /* 从redis中获取cToken对应的值 */
        String value = redisTemplate.opsForValue().get(cToken);
        /* 验证码为空 */
        if(StringUtils.isEmpty(captcha)){
            throw new CaptchaException("验证码不能为空!");
        }else if(StringUtils.isEmpty(value)){
            throw new CaptchaException("验证码不存在!");
        }else if(!StringUtils.equals(captcha,value)){
            throw new CaptchaException("验证码不匹配!");
        }
    }
}
