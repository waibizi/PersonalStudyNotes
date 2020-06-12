package com.waibizi.Test;

import com.waibizi.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/5/7 0:18
 */
@Component
public class TestDemo01 {
    @Autowired
    static TestMapper testMapper;


    public static void test(){
        System.out.println(testMapper.hashCode());
    }

}
