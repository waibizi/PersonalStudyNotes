package center.raccoon.oauth2.project.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author 许树雄
 * @Date2020/5/30 22:05
 * @Description:登录表实体类
 * @Version 1.0
 */
@Data
public class Login {
    /**
     * 登录ID
     */
    private Integer loginId;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 登录设备
     */
    private String loginEquipment;
    /**
     * 登录用户
     */
    private String  loginUser;
    /**
     * 用户登录令牌
     */
    private String token;

    public Login(Date loginTime, String loginIp, String loginEquipment, String loginUser,String token) {
        this.loginTime = loginTime;
        this.loginIp = loginIp;
        this.loginEquipment = loginEquipment;
        this.loginUser = loginUser;
        this.token = token;
    }
}
