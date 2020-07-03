package com.waibizi.service.impl;

import com.waibizi.dao.MoneyDao;
import com.waibizi.dao.RentDao;
import com.waibizi.service.RentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 13:39
 * @Description: 租房实现类
 * @Version 1.0
 */
@Service
public class RentingServiceImpl implements RentingService {
    @Autowired
    private RentDao rentDao;
    @Autowired
    private MoneyDao moneyDao;

    @Transactional
    @Override
    public void rent() {
        rentDao.rent("歪鼻子大酒店",10000);
//        moneyDao.updateMoney("酒店老板", (moneyDao.queryMoney("酒店老板")+1000));
//        moneyDao.updateMoney("歪鼻子",(moneyDao.queryMoney("歪鼻子")-1000));
    }
}
