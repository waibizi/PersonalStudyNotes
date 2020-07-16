package center.raccoon.oauth2.framework.handler;

import center.raccoon.oauth2.framework.exception.CaptchaException;
import center.raccoon.result.RaccoonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 歪鼻子、xiaoxiong
 * @Date 2020/7/7 0:08
 * @Description:
 * @Version 1.0
 */
@Component
public class RaccoonAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        /* 如果异常为自定义的验证码异常 */
        if(exception instanceof CaptchaException){
            String msg=exception.getMessage();
            response.setContentType("application/json;charset=UTF-8");
            /* 返回自定义结果 */
            response.getWriter().write(new ObjectMapper().writeValueAsString(new RaccoonResult(401,msg)));
        }
    }
}
