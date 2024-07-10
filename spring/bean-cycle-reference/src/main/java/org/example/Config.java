package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.example")
public class Config {

    @Bean(name = "a")
    public A a() {
        return new A();
    }

    @Bean(name = "b")
    public B b() {
        return new B();
    }
}
