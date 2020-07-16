package center.raccoon.oauth2.framework.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 歪鼻子、xiaoxiong
 * @Date 2020/7/7 0:11
 * @Description:
 * @Version 1.0
 */
@Component
public class RaccoonAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Throwable cause = e.getCause();
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try{
            if(cause instanceof InvalidTokenException){
                Map map=new HashMap(3);
                map.put("code",401);
                map.put("msg",e.getMessage());
                httpServletResponse.setContentType("application/json");
                ObjectMapper mapper=new ObjectMapper();
                mapper.writeValue(httpServletResponse.getOutputStream(),map);
            }
        }catch (Exception ex){
            throw new ServletException();
        }
    }
}
