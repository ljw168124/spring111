package com.ljw.service;

import com.ljw.dao.UserDAO;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LJW on 2017/8/14.
 */
@Service("userService")
public class UserServiceIml implements UserService,InitializingBean,DisposableBean{
    @Autowired
    private UserDAO userDAO;

    public UserServiceIml() {

    }

    public UserServiceIml(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void findUserByID() {
        userDAO.findUser();
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public void destroy() throws Exception {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
