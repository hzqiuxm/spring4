package com.qiuxm.lesson1;

/**
 * Created by dell on 2016/7/14.
 */
public class HelloWorld {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){

        System.out.println("Welcome to spring, hello "+ name);
    }
}
