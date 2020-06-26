package com.waibizi.service;

import com.waibizi.dao.UserDao;
import com.waibizi.pojo.User;

import java.util.List;

/**
 * @Author 歪鼻子
 * @Date 2020/6/26 18:48
 * @Description:
 * @Version 1.0
 */
@SuppressWarnings("All")
public class UserService {
    private UserDao userDao;
    public void query(){
        List<User> list = userDao.query();
        for (User u:
             list) {
            System.out.println(u.toString());
        }
    }
    public void SetUserDao(UserDao userDao){
        this.userDao = userDao;
    }
}
