package com.qiuxm.controller;

import com.qiuxm.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by dell on 2016/7/15.
 */

@Controller
public class UserController {

    @Autowired
    IUserService iUserService;

    public  void addUser(){

        System.out.println(" Controller adduser() ... ");
        iUserService.save();
    }

}
