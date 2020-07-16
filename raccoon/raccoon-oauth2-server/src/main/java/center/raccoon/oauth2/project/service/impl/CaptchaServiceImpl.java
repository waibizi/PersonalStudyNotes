package center.raccoon.oauth2.project.service.impl;

import center.raccoon.oauth2.project.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author xiaoxiong
 * @Date2020/7/5 10:52
 * @Description:验证码服务类
 * @Version 1.0
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    @Value("${server.session.timeout}")
    private Integer timeout;
    @Autowired
    private StringRedisTemplate template;
    /**
     * 创建验证码
     * @param captcha
     * @return
     */
    @Override
    public Map<String, Object> createToken(String captcha) {
        /* 创建验证码唯一标识 */
        String cToken = UUID.randomUUID().toString();
        /* 创建valueOperations */
        ValueOperations<String,String> valueOperations=template.opsForValue();
        /* 设置键值对 */
        valueOperations.set(cToken,captcha);
        /* 设置过期时间 */
        template.expire(cToken,timeout, TimeUnit.SECONDS);
        Map<String,Object> map=new HashMap<>();
        map.put("cToken",cToken);
        map.put("expire",timeout);
        return map;
    }
}
