package com.qiuxm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2016/7/18.
 */
//把类声明为一个切面:1 把该类放到IOC容器中 2 声明为一个切面
@Order(2)
@Aspect
@Component
public class LoggingAspect {

    //声明切入点表达式方法
    @Pointcut("execution( * com.qiuxm.aop.Calculator.*(..))")
    public void declareJoinPointExpression(){}

    //前置通知
    @Before("declareJoinPointExpression()")
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

    //返回通知，方法正常结束执行，可以访问方法的返回值
    @AfterReturning(value = "execution(public int com.qiuxm.aop.Calculator.*(int,int))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method "+ methodName +" ends with " + result);
    }

    //异常通知，方法出现异常时执行，可以访问到异常对象，且可以指定在特定的异常执行
    @AfterThrowing(value = "execution(public int com.qiuxm.aop.Calculator.*(int,int))",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method "+ methodName +" occurs exception " + e);
    }

    //环绕通知,需要携带一个ProceedingJoinPoint参数
    //类似于动态代理全过程：由ProceedingJoinPoint参数决定是否执行目标方法
    //环绕通知必须要有返回值，且要和目标方法一致
    @Around("execution(public int com.qiuxm.aop.Calculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pj){

        Object result = null;
        String methodName = pj.getSignature().getName();
        //执行目标方法
        try {
            //前置通知位置
            result = pj.proceed();
            //返回通知位置
        } catch (Throwable throwable) {
            //异常通知位置
            throwable.printStackTrace();
        }
        //后置通知位置
        return result;
    }


}
