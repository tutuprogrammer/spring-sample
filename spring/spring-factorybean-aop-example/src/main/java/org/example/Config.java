package org.example;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Config {

    @Bean(name = "beforeAdvice")
    public MethodBeforeAdvice beforeAdvice() {
        //前置通知
        return (method, args, target) -> System.out.println("execute MethodBeforeAdvice#before()");
    }

    @Bean(name = "afterReturningAdvice")
    public AfterReturningAdvice afterReturningAdvice() {
        //后置通知
        return (returnValue, method, args, target) -> System.out.println("execute AfterReturningAdvice#afterReturning()");
    }

    @Bean(name = "myBean")
    public MyBean myBean()
    {
        MyBean myBean = new MyBean();
        myBean.setName("myBean");
        return myBean;
    }

    @Bean(name = "proxyBean")
    public ProxyFactoryBean proxyBean(MyBean myBean) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //指定target为MyBean
        proxyFactoryBean.setTarget(myBean);
        //指定前置后置通知
        proxyFactoryBean.setInterceptorNames("beforeAdvice", "afterReturningAdvice");
        return proxyFactoryBean;
    }
}
