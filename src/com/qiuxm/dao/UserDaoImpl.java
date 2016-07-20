package com.qiuxm.dao;

import com.qiuxm.db.DB;
import org.springframework.stereotype.Repository;

/**
 * Created by hzqiuxm on 2016/7/20 0020.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public int setp1(int a) {
        System.out.println("Do something in step1 ........11111111111.........");
        return DB.operator1(a);
    }

    @Override
    public int setp2(int a) {

        System.out.println("Do something in step2 ........222222222222.........");
        return DB.operator2(a);

    }

    @Override
    public int step3(int a) {
        //这里出错后operation1被执行
        int c,b;
        c = 10;
        b = c/0;
        System.out.println("Do something in step3 ........3333333333333.........");
        return DB.operator3(a);
    }
}
