package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MyBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    public MyBean() {
        System.out.println("execute MyBean#construct()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("execute MyBean#setName()");
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("execute BeanFactoryAware#setBeanFactory()");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("execute BeanNameAware#setBeanName()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("execute DisposableBean#destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("execute InitializingBean#afterPropertiesSet()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("execute ApplicationContextAware#setApplicationContext()");
    }

    public void doInit() {
        System.out.println("execute MyBean#doInit()");
    }

    public void doDestory() {
        System.out.println("execute MyBean#doDestory()");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("execute MyBean#postConstruct()");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("execute MyBean#preDestory()");
    }
}
