package com.waibizi.aop;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Author 歪鼻子
 * @Date 2020/5/30 20:16
 * @Description: 切面类：aop 编程里面有几个通知： 前置通知 后置通知 运行通知 异常通知 环绕通知
 * @Version 1.0
 */

@Component
@Aspect
public class AopLog {
    /**
     * 正常返回通知
     */
    @AfterReturning("execution(* com.waibizi.service.impl.RentingServiceImpl.rent(..))")
    public void returning() {
        System.out.println("正常返回通知");
    }
}

//    /**
//     * 前置通知，在方法运行钱执行
//     */
//    @Before("execution(* com.waibizi.service.RentingService.rent(..))")
//    public void Before(){
//        System.out.println("前置通知 在方法之前执行...");
//    }
//    /**
//     * 异常返回通知
//     */
//    @AfterThrowing("execution(* com.waibizi.service.RentingService.rent(..))")
//    public void afterThrowing() {
//        System.out.println("异常返回通知");
//    }
//    /**
//     * 环绕通知 在方法之前和之后处理事情
//     */
//    @Around("execution(* com.waibizi.service.RentingService.rent(..))")
//    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        //调用方法之前执行
//        System.out.println("环绕通知 调用方法之前执行");
//        proceedingJoinPoint.proceed();// 代理调用方法 注意点： 如果调用方法抛出异常不会执行后面代码
//        //调用方法之后执行
//        System.out.println("环绕通知 调用方法之后执行");
//    }

//    /**
//     * 后置通知 在方法运行后执行
//     */
//    @After("execution(* com.waibizi.service.RentingService.rent(..))")
//    public void after() {
//        System.out.println("后置通知 在方法之后执行...");
//    }



