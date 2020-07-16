package center.raccoon.oauth2.framework.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author xiaoxiong
 * @Date2020/7/5 23:34
 * @Description:自定义验证码异常，继承AuthenticationException
 * @Version 1.0
 */
public class CaptchaException extends AuthenticationException {
    public CaptchaException(String msg) {
        super(msg);
    }
}
