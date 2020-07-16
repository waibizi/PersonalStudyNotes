package center.raccoon.oauth2.project.service;

import center.raccoon.oauth2.project.model.Login;

/**
 * @Author xiaoxiong
 * @Date2020/5/31 10:30
 * @Description:登录服务接口
 * @Version 1.0
 */
public interface LoginService {
    /**
     * 添加登录信息
     * @param login
     * @return
     */
    int addLoginRecord(Login login);
}
