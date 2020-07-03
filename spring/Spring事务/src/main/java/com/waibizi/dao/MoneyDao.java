package com.waibizi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 13:41
 * @Description:
 * @Version 1.0
 */
@Repository
public class MoneyDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateMoney(String name, Integer balance){
        String sql = "UPDATE money SET balance = ? WHERE name = ?";
        jdbcTemplate.update(sql,(ps)->{
            ps.setInt(1,balance);
            ps.setString(2,name);
        });
        System.out.println(name+"----------------余额更新成功!!!!!");
    }
    public int queryMoney(String name){
        Integer money;
        String sql = "SELECT balance FROM money WHERE name = ?";
        money = jdbcTemplate.queryForObject(sql,new Object[]{name},Integer.class);
        return money;
    }
}
