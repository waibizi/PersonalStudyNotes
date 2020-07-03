package com.waibizi.aop;
import com.waibizi.annotation.WaibiziTransactional;
import com.waibizi.transaction.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import java.lang.reflect.Method;

/**
 * @Author 歪鼻子
 * @Date 2020/7/3 21:50
 * @Description:
 * @Version 1.0
 */
@Component
@Aspect
public class AopTransaction {
    @Autowired
    private TransactionUtils transactionUtils;
    /* 一定会执行的的AOP */
    @AfterThrowing("execution(* com.waibizi.service.*.*.*(..))")
    public void after(){
        transactionUtils.rollback();
        System.out.println("回滚事务");
    }
    @Around("execution(* com.waibizi.service.*.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        WaibiziTransactional annotation = getTransactional(proceedingJoinPoint);
        if (annotation == null){
            return;
        }
        TransactionStatus transactionStatus = transactionUtils.begin();
        System.out.println("开启事务");
        proceedingJoinPoint.proceed();
        transactionUtils.commit(transactionStatus);
        System.out.println("提交事务");
    }
    public WaibiziTransactional getTransactional(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        /* 获取方法签名的名称 */
        String methodName = proceedingJoinPoint.getSignature().getName();
        /* 获取目标对象 */
        Class<?> targetObject = proceedingJoinPoint.getTarget().getClass();
        /* 获取目标对象的类型 */
        Class<?>[] targetType = ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterTypes();
        /* 获取目标对象的方法 */
        Method objectMethod = targetObject.getMethod(methodName,targetType);
        /* 判断是否有自定义注解 */
        WaibiziTransactional annotation = objectMethod.getDeclaredAnnotation(WaibiziTransactional.class);
        if (annotation == null){
            System.out.println("方法上没有注解");
            return null;
        }
        return annotation;
    }
}
