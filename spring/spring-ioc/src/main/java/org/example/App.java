package org.example;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 */
@Configuration
public class App {

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

    @Bean(name = "proxyBean")
    public ProxyFactoryBean proxyBean(MyBean myBean) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //指定target为MyBean
        proxyFactoryBean.setTarget(myBean);
        //指定前置后置通知
        proxyFactoryBean.setInterceptorNames("beforeAdvice", "afterReturningAdvice");
        return proxyFactoryBean;
    }

    public static void main(String[] args) {
        //类都放在org.example包下,扫描这个包下所有Bean
        BeanFactory beanFactory = new AnnotationConfigApplicationContext("org.example");
        //getBean()如果不带&前缀,返回的是生产的Bean,这里是MyBean的代理了
        MyBean myBean = (MyBean) beanFactory.getBean("proxyBean");
        //调用方法,会执行前置和后置通知
        myBean.getName();
    }
}
