package com.ljw.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

/**
 * Created by LJW on 2017/8/14.
 */
@Repository
public class UserDAOIml implements UserDAO,DisposableBean,InitializingBean{
    @Override
    public void findUser() {
        System.out.println("找到一个小朋友");
    }

    @Override
    public void destroy() throws Exception {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
