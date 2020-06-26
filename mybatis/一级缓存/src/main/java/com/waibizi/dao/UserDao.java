package com.waibizi.dao;

import com.waibizi.pojo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 歪鼻子
 * @Date 2020/6/26 18:19
 * @Description:
 * @Version 1.0
 */
/* 开启二级缓存 */
@CacheNamespace
public interface UserDao {
    @Select("SELECT * FROM user")
    public List<User> query();
}
