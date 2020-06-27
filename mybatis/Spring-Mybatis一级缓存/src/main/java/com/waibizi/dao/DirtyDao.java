package com.waibizi.dao;

import org.apache.ibatis.annotations.Update;

/**
 * @Author 歪鼻子
 * @Date 2020/6/26 23:45
 * @Description:
 * @Version 1.0
 */
public interface DirtyDao {
    @Update("UPDATE user SET name='妲己' WHERE id= 4")
    void update();
}
