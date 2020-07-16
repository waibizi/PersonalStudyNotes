package center.raccoon.oauth2.project.service.impl;

import center.raccoon.oauth2.project.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;

/**
 * @Author 歪鼻子
 * @Date 2020/7/10 21:39
 * @Description:
 * @Version 1.0
 */
@Service
public class OnlineServiceImpl implements OnlineService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ConsumerTokenServices consumerTokenServices;
    @Autowired
    TokenStore tokenStore;
    @Override
    public void insertOnlineUser(String userName, OAuth2AccessToken body, HttpServletRequest request){
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        if (userName != null){
            redisTemplate.opsForList().leftPush(userName.trim(),body.getValue());
            redisTemplate.expire(userName, Duration.ofHours(2));
            redisTemplate.opsForList().leftPush(body.getRefreshToken().getValue(),userName);
            redisTemplate.expire(body.getRefreshToken().getValue(), Duration.ofHours(2));
        }else {
            String refreshToken = request.getParameter("refresh_token");
            String uname = (String) redisTemplate.opsForList().rightPop(refreshToken);
            redisTemplate.opsForList().rightPop(uname);
            redisTemplate.opsForList().leftPush(uname,body.getValue());
            redisTemplate.expire(uname, Duration.ofHours(2));
            redisTemplate.opsForList().leftPush(body.getRefreshToken().getValue(),uname);
            redisTemplate.expire(body.getRefreshToken().getValue(), Duration.ofHours(2));
        }
    }
    @Override
    public void kickOut(String jti){
        System.out.println(jti);
        Object accessToken = redisTemplate.opsForHash().get(jti, "access_token");
        System.out.println(accessToken);
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken.toString());
        tokenStore.removeAccessToken(oAuth2AccessToken);
    }
}
