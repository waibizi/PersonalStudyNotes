package center.raccoon.oauth2.framework.exception;

import center.raccoon.result.RaccoonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @Author xiaoxiong
 * @Date2020/5/29 14:37
 * @Description:
 * @Version 1.0
 */
@Component
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<RaccoonResult> translate(Exception e) throws Exception {
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        if (e instanceof InvalidTokenException) {
            System.out.println(((OAuth2Exception) e).getHttpErrorCode());
            return ResponseEntity.ok()
                    .body(new RaccoonResult(400,"令牌失效"));
        }
        return null;
    }
}
