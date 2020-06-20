package com.waibizi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 歪鼻子
 * @Date 2020/6/17 1:17
 * @Description:
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT");

        Statement statement = connection.createStatement();
        String sql = "select * from user_innodb";
        ResultSet result = statement.executeQuery("sql");
        connection.close();


        List<String> list = new ArrayList<>();
        list.stream().filter((param)->param!=null);
    }
}
