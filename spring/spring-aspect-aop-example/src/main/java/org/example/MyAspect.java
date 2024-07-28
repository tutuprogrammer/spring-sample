package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 1. MyAspect也是一个Bean,使用@Component注解
 * 2. pointcut定义切点
 * 3. @Before,@After...是对切点的Advice
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* org.example.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("execute MyAspect#before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("execute MyAspect#after");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("execute MyAspect#around.before");
        Object retVal = pjp.proceed();
        System.out.println("execute MyAspect#around.after");
        return retVal;
    }

    @AfterReturning(pointcut = "pointcut()")
    public void afterReturning() {
        System.out.println("execute MyAspect#afterReturning");
    }

    @AfterThrowing(pointcut = "pointcut()")
    public void afterThrowing() {
        System.out.println("execute MyAspect#afterThrowing");
    }
}
