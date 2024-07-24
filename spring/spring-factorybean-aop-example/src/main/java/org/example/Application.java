package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String[] args) {
        //类都放在org.example包下,扫描这个包下所有Bean
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(Config.class);
        //getBean()如果不带&前缀,返回的是生产的Bean,这里是MyBean的代理了
        MyBean myBean = (MyBean) beanFactory.getBean("proxyBean");
        //调用方法,会执行前置和后置通知
        myBean.exec();
    }
}
