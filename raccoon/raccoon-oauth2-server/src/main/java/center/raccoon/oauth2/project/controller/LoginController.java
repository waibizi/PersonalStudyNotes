package center.raccoon.oauth2.project.controller;

import center.raccoon.oauth2.project.service.CaptchaService;
import center.raccoon.result.RaccoonResult;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @Author 歪鼻子、xiaoxiong
 * @Date 2020/7/4 17:53
 * @Description:
 * @Version 1.0
 */
@RestController
public class                                                                                          LoginController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Autowired
    private CaptchaService captchaService;
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    /**
     * 获取验证码的请求映射
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/captcha")
    public RaccoonResult getCaptcha(HttpServletResponse response) throws IOException {
        //创建谜底
        String text = defaultKaptcha.createText();
        //创建字节数组输出流
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        //根据谜底创建图片
        BufferedImage image=defaultKaptcha.createImage(text);
        //将图片写进输出流
        ImageIO.write(image,"jpg",outputStream);
        //创建BASE64编码对象
        BASE64Encoder encoder=new BASE64Encoder();
        //调用验证码服务类
        Map<String, Object> map = captchaService.createToken(text);
        /* 对输出流的数据进行BASE64的编码,并放入map当中 */
        map.put("img",encoder.encode(outputStream.toByteArray()));
        return new RaccoonResult(200,"获取验证码成功",map);
    }
    @GetMapping("/redis")
    public String TestRedis(){
        Object access_token = redisTemplate.opsForHash().get("328f4a83-123f-4804-8791-a24bea464470", "access_token");
        return access_token.toString();
    }
}
