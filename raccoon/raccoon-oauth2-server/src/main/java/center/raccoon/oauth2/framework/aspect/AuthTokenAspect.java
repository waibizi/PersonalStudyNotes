package center.raccoon.oauth2.framework.aspect;

import center.raccoon.oauth2.framework.util.LoginUtil;
import center.raccoon.oauth2.project.model.Login;
import center.raccoon.oauth2.project.model.Response;
import center.raccoon.oauth2.project.service.LoginService;
import center.raccoon.oauth2.project.service.impl.OnlineServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author 歪鼻子
 * @Date 2020/7/4 22:48
 * @Description: 拦截Oauth2的登录成功返回值，再次封装进行返回
 * @Version 1.0
 */
@Component
@Aspect
public class AuthTokenAspect {
    @Autowired
    private LoginService loginService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OnlineServiceImpl onlineService;

    @Around("execution(* org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.postAccessToken(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        /*  放行 */
        Response response = new Response();
        Object proceed = pjp.proceed();
        String userName = request.getParameter("username");
        if (proceed != null ) {
            ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>)proceed;
            OAuth2AccessToken body = responseEntity.getBody();
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                response.setErrorcode("200");
                response.setValue("授权成功");
                response.setData(body);
                /* 记录访问记录 */

                loginService.addLoginRecord
                        (new Login(new Date(), LoginUtil.getIpAddress(request),
                                LoginUtil.getDeviceType(request),userName,body.getValue()));
                   //onlineService.insertOnlineUser(userName,body,request);

            } else {
                response.setErrorcode("422");
                response.setValue("授权失败");
            }
        }
        return ResponseEntity
                .status(200)
                .body(response);
    }
}
