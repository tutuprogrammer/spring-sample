package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class Application {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(Config.class);
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
