package com.waibizi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 13:40
 * @Description:
 * @Version 1.0
 */
@Repository
public class RentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void rent(String name,Integer price){
        String sql = "INSERT INTO rent(name,price) VALUES(?,?)";
        int updateResult = jdbcTemplate.update(sql,(ps)->{
            ps.setString(1,name);
            ps.setInt(2,price);
        });
    }
}
