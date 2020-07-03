package com.waibizi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 13:41
 * @Description:
 * @Version 1.0
 */

public class MoneyDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateMoney(String name, Integer money){
        String sql = "UPDATE money SET money = ? WHERE name = ?";
        jdbcTemplate.update(sql,(ps)->{
            ps.setString(1,name);
            ps.setInt(2,money);
        });
    }
    public int queryMoney(String name){
        final int money;
        String sql = "SELECT money FROM money WHERE name = "+name;
        money = jdbcTemplate.queryForInt(sql);
        return money;
    }
}
