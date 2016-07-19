package com.qiuxm.services;

import org.springframework.stereotype.Service;

/**
 * Created by dell on 2016/7/15.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Override
    public void save() {
        System.out.println("UserServiceImpl do the save end!");
    }
}
