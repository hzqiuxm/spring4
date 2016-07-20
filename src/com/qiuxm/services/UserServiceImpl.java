package com.qiuxm.services;

import com.qiuxm.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dell on 2016/7/15.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public void save() {
        System.out.println("UserServiceImpl do the save end!");
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void doSomething() {

        int a = 1;
        int b,c,d;
        b = userDao.setp1(a);
        System.out.println("b = "+b);
        c = userDao.setp2(b);
        System.out.println("c = "+c);
        d = userDao.step3(c);
        System.out.println("d = "+d);

    }
}
