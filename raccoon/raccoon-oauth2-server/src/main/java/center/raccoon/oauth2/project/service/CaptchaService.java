package center.raccoon.oauth2.project.service;

import java.util.Map;

/**
 * @Author xiaoxiong
 * @Date2020/7/5 10:50
 * @Description:验证码服务接口
 * @Version 1.0
 */
public interface CaptchaService {
    /**
     * 创建验证码
     * @param captcha
     * @return
     */
    Map<String,Object> createToken(String captcha);
}
