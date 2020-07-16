package center.raccoon.oauth2.project.service.impl;

import center.raccoon.oauth2.project.mapper.UserMapper;
import center.raccoon.oauth2.project.model.User;
import center.raccoon.oauth2.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author xiaoxiong
 * @Date2020/5/27 20:21
 * @Description:用户逻辑处理类
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 注入UserMapper
     */
    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户名获取用户详情
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public User getUserByUserName(String username)  throws UsernameNotFoundException{
        if (username==null||username.trim().length()<=0) {
            throw new UsernameNotFoundException("用户名为空");
        }
        User userByUserName = userMapper.getUserByUserName(username);
        if (userByUserName != null){
            return userByUserName;
        }
        throw new UsernameNotFoundException("用户不存在!");
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Transactional
    @Override
    public int addUser(User user) {
        User userByUserName = userMapper.getUserByUserName(user.getUserName());
        if(userByUserName!=null){
            return -1;
        }
        int count = userMapper.addUser(user);
        return count;
    }
}
