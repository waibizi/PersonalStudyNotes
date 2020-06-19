package com.waibizi.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @Author 吴典秋
 * @Date 2020/5/31 2:21
 * @Description:编程事务（需要手动begin 手动回滚  手都提交）
 * @Version 1.0
 */
@Component
public class TransactionUtils {
    /**
     * 注入事务源
     */
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    /**
     * 开启事务,采用默认的事务传播级别
     */
    public TransactionStatus begin(){
        TransactionStatus transaction = dataSourceTransactionManager.
                getTransaction(new DefaultTransactionAttribute());
        return transaction;
    }
    /**
     * 提交事务
     */
    public void commit(TransactionStatus transaction){
        dataSourceTransactionManager.commit(transaction);
    }
    /**
     * 回滚事务
     */
    public void rollback(TransactionStatus transaction){
        dataSourceTransactionManager.rollback(transaction);
    }
}