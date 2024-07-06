package org.example;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.lifecycle")
public class Config {

    @Bean(name = "myBean", initMethod = "doInit", destroyMethod = "doDestory")
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName("myBean");
        return myBean;
    }

    @Bean
    public BeanNameAutoProxyCreator proxy()
    {
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        proxyCreator.setBeanNames("myBean");
        return proxyCreator;
    }


}
