package center.raccoon.oauth2.framework.aspect;
import center.raccoon.oauth2.project.model.Response;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import java.io.IOException;

/**
 * @Author 歪鼻子
 * @Date 2020/7/7 1:02
 * @Description:
 * @Version 1.0
 */
public class ResponseSerializer extends StdSerializer<Response> {
    public ResponseSerializer() {
        super(Response.class);
    }

    @Override
    public void serialize(Response value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        OAuth2AccessToken oAuth2AccessToken = (OAuth2AccessToken) value.getData();
        gen.writeStartObject();
        gen.writeStringField("code", value.getErrorcode());
        gen.writeStringField("msg", value.getValue());
        gen.writeObjectFieldStart("data");
        gen.writeStringField("access_token", oAuth2AccessToken.getValue());
        gen.writeStringField("token_type", oAuth2AccessToken.getTokenType());
        gen.writeStringField("refresh_token", oAuth2AccessToken.getRefreshToken().getValue());
        gen.writeEndObject();
        gen.writeEndObject();
    }
}
