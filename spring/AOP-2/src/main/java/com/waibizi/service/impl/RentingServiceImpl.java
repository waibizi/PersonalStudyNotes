package com.waibizi.service.impl;

import com.waibizi.dao.RentDao;
import com.waibizi.service.RentingService;
import com.waibizi.transaction.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

/**
 * @Author 歪鼻子
 * @Date 2020/5/30 20:28
 * @Description:
 * @Version 1.0
 */
@Service
public class RentingServiceImpl implements RentingService {
    @Autowired
    private RentDao rentDao;

    @Override
    public void rent() {
        rentDao.rent("歪鼻子大酒店",10000);
        System.out.println(1/0);
        rentDao.rent("歪鼻子客栈",100);
    }
}



//    @Autowired
//    private TransactionUtils transactionUtils;
//    public void rent() {
//        TransactionStatus transactionStatus = null;
//        try{
//            //开启事务
//            transactionStatus = transactionUtils.begin();
//            System.out.println("开启事务");
//            rentDao.rent("歪鼻子大酒店",10000);
//            System.out.println(1/0);
//            rentDao.rent("歪鼻子客栈",100);
//            //提交事务
//            if (transactionStatus!=null){
//                transactionUtils.commit(transactionStatus);
//                System.out.println("提交事务");
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            //回滚事务
//            if (transactionStatus!=null){
//                transactionUtils.rollback(transactionStatus);
//                System.out.println("回滚事务");
//            }
//        }
//    }
