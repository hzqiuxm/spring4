package com.qiuxm.aop;

/**
 * Created by dell on 2016/7/18.
 */
public class CalculatorImplLog implements  Calculator{
    @Override
    public int add(int i, int j) {

        //增加数据验证
        if(!checkParm(i,j)){
            System.out.println("param is not ok!");
            return -1;
        }
        //增加日志
        System.out.println("begin method add() =============");
        int result = i + j;
        System.out.println("end method add() ============");
        return result;
    }

    @Override
    public int sub(int i, int j) {

        //增加数据验证
        if(!checkParm(i,j)){
            System.out.println("param is not ok!");
            return -1;
        }
        //增加日志
        System.out.println("begin method sub() =============");
        int result = i - j;
        System.out.println("end method sub() ============");

        return result;
    }

    @Override
    public int mul(int i, int j) {

        //增加数据验证
        if(!checkParm(i,j)){
            System.out.println("param is not ok!");
            return -1;
        }
        //增加日志
        System.out.println("begin method mul() =============");
        int result = i * j;
        System.out.println("end method mul() ============");

        return result;
    }

    @Override
    public int div(int i, int j) {

        //增加数据验证
        if(!checkParm(i,j)){
            System.out.println("param is not ok!");
            return -1;
        }
        //增加日志
        System.out.println("begin method div() =============");
        int result = i / j;
        System.out.println("end method div() ============");

        return result;
    }

    protected boolean checkParm(int i, int j){

        System.out.println("begin chenk param .......");
        if(i < 0 || j < 0){
            return false;
        }

        if(j == 0){
            return false;
        }

        System.out.println("param is ok .......");
        return true;
    }
}
