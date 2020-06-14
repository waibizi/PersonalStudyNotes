package com.waibizi.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @Author 歪鼻子
 * @Date 2020/6/14 1:05
 * @Description:
 * @Version 1.0
 */

/**
 * BeanFactoryPostProcessor和BeanPostProcessor这两个接口都是初始化bean时对外暴露的入口之一
 * 1.BeanFactoryPostProcessor和BeanPostProcessor都是spring当中的bean工厂对于bean属性处理的容器
 *      简单来说就是可以管理bean工厂内部所有未实例化的数据（即BeanDefinition）当中的数据
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        /*
        System.out.println("调用了自定义的BeanFactoryPostProcessor"+beanFactory);
        String[] names = beanFactory.getBeanDefinitionNames();
        //获取所有的bean名称列表
        for (String name : names) {
            BeanDefinition bd = beanFactory.getBeanDefinition(name);
            System.out.println(name + "bean properties = " + bd.getPropertyValues().toString());
        }
         */
        beanFactory.getBeanDefinition("FirstBean");

    }
}
