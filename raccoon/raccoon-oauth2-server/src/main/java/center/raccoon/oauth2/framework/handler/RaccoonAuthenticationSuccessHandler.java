package center.raccoon.oauth2.framework.handler;

import center.raccoon.result.RaccoonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author 歪鼻子、xiaoxiong
 * @Date 2020/7/7 0:10
 * @Description:
 * @Version 1.0
 */
@Component
public class RaccoonAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(RaccoonResult.success("登陆成功",authentication.getDetails())));
    }
}