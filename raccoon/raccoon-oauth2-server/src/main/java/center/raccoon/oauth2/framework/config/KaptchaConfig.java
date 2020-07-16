package center.raccoon.oauth2.framework.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author xiaoxiong
 * @Date2020/7/5 10:05
 * @Description:验证码配置类
 * @Version 1.0
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha captchaCreate(){
        /* Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。这里用来配置kaptcha */
        Properties properties = new Properties();
        /* 配置边框 */
        properties.put("kaptcha.border", "no");
        /* 字体颜色 */
        properties.put("kaptcha.textproducer.font.color", "105,179,90");
        properties.put("kaptcha.textproducer.char.space", "7");
        /* 干扰线颜色 */
        properties.put("kaptcha.noise.color","105,179,90");
        properties.put("kaptcha.textproducer.char.length","4");
        /* 图片高度 */
        properties.put("kaptcha.image.height","35");
        /* 图片宽度 */
        properties.put("kaptcha.image.width","90");
        /* 字体大小 */
        properties.put("kaptcha.textproducer.font.size","25");
        /* 创建一个kaptcha配置类 */
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        /* 设置配置信息 */
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
