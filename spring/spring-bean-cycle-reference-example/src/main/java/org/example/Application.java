package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Application
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        A a = (A)context.getBean("a");
        B b = (B)context.getBean("b");
        System.out.println("a is " + a + " and b.a is " + b.getA());
        System.out.println("b is " + b + " and a.b is " + a.getB());
    }
}
