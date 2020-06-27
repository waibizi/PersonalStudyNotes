package com.waibizi.service;

import com.waibizi.dao.DirtyDao;
import com.waibizi.dao.UserDao;
import com.waibizi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 歪鼻子
 * @Date 2020/6/26 22:03
 * @Description:
 * @Version 1.0
 */
@SuppressWarnings("All")
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DirtyDao dirtyDao;
    public void query(){
        List<User> list = userDao.query();
        for (User u:
                list) {
            System.out.println(u.toString());
        }
    }
    public void update(){
        dirtyDao.update();
    }
}

