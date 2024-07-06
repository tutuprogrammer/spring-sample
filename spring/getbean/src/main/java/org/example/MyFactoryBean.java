package org.example;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<MyBean> {

    @Override
    public MyBean getObject() throws Exception {
        MyBean myBean = new MyBean();
        myBean.setName("myBeanFromFactory");
        return myBean;
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}