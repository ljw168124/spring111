package com.ljw.cutpoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by LJW on 2017/8/15.
 */
@Component
@Aspect
public class UserInterceptor {

    @Pointcut("execution(* com.ljw.service.UserService.*(..))")
    private void myCut () {

    }
    @Before(value = "myCut()")
    public void before () {
       System.out.println("before");
   }
//   @After(value = "myCut()")
   public void after () {
       System.out.println("after");
   }

   @Around(value = "myCut()")
   public Object around (ProceedingJoinPoint joinPoint) throws Throwable {
       System.out.println("前");
        Object obj = joinPoint.proceed();
       System.out.println("后");
        return obj;
   }
}
