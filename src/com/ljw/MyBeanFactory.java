package com.ljw;

import com.ljw.dao.UserDAOIml;
import com.ljw.service.UserService;
import com.ljw.service.UserServiceIml;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * Created by LJW on 2017/8/14.
 */
public class MyBeanFactory {

    public static UserService createUserService () {
        final UserService userService = new UserServiceIml(new UserDAOIml());
        return (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("我再前");
                Object result = method.invoke(userService,objects);
                System.out.println("我再后");
                return null;
            }
        });
    }
}
