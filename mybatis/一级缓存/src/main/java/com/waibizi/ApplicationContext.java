package com.waibizi;

import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @Author 歪鼻子
 * @Date 2020/6/26 18:04
 * @Description:
 * @Version 1.0
 */
public class ApplicationContext {
    public static void main(String[] args) {
        /* 初始化数据源 */
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        /* 事务 */
        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        /* 构建环境变量 */
        Environment environment =
                new Environment("development",transactionFactory,dataSource);
        Configuration configuration = new Configuration(environment);
        /* log4j 打印sql */
        configuration.setLogImpl(Log4jImpl.class);

    }
}
