package com.qiuxm.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by dell on 2016/7/18.
 */
public class CalculatorImplProxy {

    //要代理的对象
    private Calculator target;

    public CalculatorImplProxy(Calculator target) {
        this.target = target;
    }

    public Calculator getLoggingProxy(){
        Calculator proxy = null;

        //加载器
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型
        Class [] interfaces = new Class[]{Calculator.class};
        //代理对象方法时，执行的代码
        InvocationHandler hander = new InvocationHandler() {
            /**
             *
             * @param proxy 正在返回的那个代理对象，一般情况下invoke都不适用该对象
             * @param method 正在被调用的方法
             * @param args 调用方法时，传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String methodName = method.getName();
                //检查参数
                checkParm((Integer) args[0],(Integer)args[1]);
                //日志
                System.out.println("The method "+methodName + "() begin with " + Arrays.asList(args) + "=============");
                //执行方法
                Object result = method.invoke(target,args);
                System.out.println("The method "+methodName + "() end =============");
                return result;
            }
        };

        proxy = (Calculator) Proxy.newProxyInstance(loader,interfaces,hander);

        return proxy;
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
