package center.raccoon.oauth2.framework.aspect;

import center.raccoon.result.RaccoonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

/**
 * @Author 歪鼻子
 * @Date 2020/7/4 22:48
 * @Description: 拦截Oauth2的登录成功返回值，再次封装进行返回
 * @Version 1.0
 */
@Component
@Aspect
public class AuthTokenAspect {
    @Around("execution(* org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.postAccessToken(..))")
    public RaccoonResult handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = proceedingJoinPoint.proceed();
        if(proceed != null) {
            ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>) proceed;
            OAuth2AccessToken body = responseEntity.getBody();
            return RaccoonResult.success("登录成功",body);
        }
        return RaccoonResult.error("登录失败");
    }
}
