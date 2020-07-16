package center.raccoon.oauth2.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.store.JwtClaimsSetVerifier;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author 许树雄
 * @Date2020/7/11 9:57
 * @Description:自定义令牌验证类，判断令牌是否有效
 * @Version 1.0
 */
@Component
public class RedisJwtClaimsSetVerifier implements JwtClaimsSetVerifier {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Override
    public void verify(Map<String, Object> map) throws InvalidTokenException {
        if(map.containsKey("jti")){
            String jti = map.get("jti").toString();
            String token = redisTemplate.opsForHash().get(jti,"access_token").toString();
            if(token==null){
                throw new InvalidTokenException("无效令牌");
            }
        }
    }
}
