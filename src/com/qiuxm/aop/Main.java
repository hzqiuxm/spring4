package com.qiuxm.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2016/7/18.
 */
public class Main {

    public static void main(String[] args) {

        //侵入式的写法
        Calculator calculator1 = new CalculatorImplLog();
        System.out.println(calculator1.add(1,2));
//        calculator1.div(2,0);

        System.out.println("----------------------------------------------------");

        Calculator target = new CalculatorImpl();
        Calculator calculator2 = new CalculatorImplProxy(target).getLoggingProxy();
        System.out.println(calculator2.add(3,4));

        ApplicationContext appletContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calculator = (Calculator) appletContext.getBean("calculatorImpl");
        System.out.println(calculator.add(3,4));

        System.out.println(calculator.div(16,4));

    }
}
