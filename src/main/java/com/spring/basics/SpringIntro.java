package com.spring.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringIntro {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("sc_spring.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }
}

