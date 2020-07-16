package center.raccoon.oauth2.project.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author xiaoxiong
 * @Date2020/5/27 20:21
 * @Description:用户实体类
 * @Version 1.0
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID=1L;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 该用户是否可以用
     */
    private String userEnable;
}
