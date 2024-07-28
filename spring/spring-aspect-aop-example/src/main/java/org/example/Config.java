package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 1. @EnableAspectJAutoProxy开启Aspect支持
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.example")
public class Config {
}
