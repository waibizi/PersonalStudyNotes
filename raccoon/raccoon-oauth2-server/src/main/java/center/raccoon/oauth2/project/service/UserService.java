package center.raccoon.oauth2.project.service;

import center.raccoon.oauth2.project.model.User;

/**
 * @Author xiaoxiong
 * @Date2020/5/27 20:21
 * @Description:用户服务接口
 * @Version 1.0
 */
public interface UserService {
    /**
     * 根据用户名获取用户详情
     * @param username
     * @return
     */
    User getUserByUserName(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
}
