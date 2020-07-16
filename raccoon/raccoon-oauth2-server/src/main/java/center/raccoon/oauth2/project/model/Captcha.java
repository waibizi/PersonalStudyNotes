package center.raccoon.oauth2.project.model;

import lombok.Data;

/**
 * @Author xiaoxiong
 * @Date2020/7/5 10:00
 * @Description:验证码对象
 * @Version 1.0
 */
@Data
public class Captcha {
    //ID
    private String token;
    //谜底
    private String captcha;
}
