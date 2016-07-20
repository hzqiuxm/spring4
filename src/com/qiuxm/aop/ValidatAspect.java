package com.qiuxm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by hzqiuxm on 2016/7/20 0020.
 * 数据检查切面
 */
@Order(1)
@Aspect
@Component
public class ValidatAspect {

    @Before("execution(* com.qiuxm.aop.Calculator.*(..))")
    public boolean checkArgs(JoinPoint joinPoint){
        System.out.println("check Args : " + Arrays.asList(joinPoint.getArgs()));
        return true;
    }
}
