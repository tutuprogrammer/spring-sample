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
    public static void main(String[] args) {
        //三个类都放在org.example包下,扫描这个包下所有Bean
        BeanFactory beanFactory = new AnnotationConfigApplicationContext("org.example");
        //这是正常注册的Bean实例
        MyBean myBean = (MyBean) beanFactory.getBean("myBean");
        System.out.println(myBean);

        //带&前缀返回Factorybean本身
        MyFactoryBean myFactoryBean = (MyFactoryBean) beanFactory.getBean("&myFactoryBean");
        System.out.println(myFactoryBean);

        //不带&前缀返回FactoryBean生产的Bean
        MyBean myBeanFromFactory = (MyBean) beanFactory.getBean("myFactoryBean");
        System.out.println(myBeanFromFactory);
    }
}
