package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with a @Before advice


    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forAllDaoMethods() { }

    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    @Before("forAllDaoMethods()")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + ": Before adding account to the database");
    }
}
