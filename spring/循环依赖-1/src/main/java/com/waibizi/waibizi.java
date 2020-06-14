package com.waibizi;

import com.waibizi.bean.FirstBean;
import com.waibizi.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 21:31
 * @Description:
 * @Version 1.0
 */
public class waibizi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        FirstBean firstBean = (FirstBean) ac.getBean("FirstBean");
        firstBean.toInvokeOtherBean();
    }
}
