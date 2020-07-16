package center.raccoon.oauth2.project.service.impl;

import center.raccoon.oauth2.project.mapper.LoginMapper;
import center.raccoon.oauth2.project.model.Login;
import center.raccoon.oauth2.project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xiaoxiong
 * @Date2020/5/31 10:31
 * @Description:
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 自动注入LoginMapper
     */
    @Autowired
    LoginMapper loginMapper;
    /**
     * 添加登录记录
     * @param login
     * @return
     */
    @Override
    public int addLoginRecord(Login login) {
        int count = loginMapper.addLoginRecord(login);
        return count;
    }
}
