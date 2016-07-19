package com.qiuxm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2016/7/18.
 */
//把类声明为一个切面:1 把该类放到IOC容器中 2 声明为一个切面
@Aspect
@Component
public class LoggingAspect {

    //前置通知
    @Before("execution(public int com.qiuxm.aop.Calculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The Method " + methodName +  "() begins with agrs : " + args +"......");
    }

    //后置通知，在目标方法执行后执行，无论是否发生异常
    @After("execution(public int com.qiuxm.aop.Calculator.*(int,int))")
    public void afterMethod(JoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method " + methodName +  "() end ......");
    }
}
