package com.spring.injectingcollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("sc_spring_collections");


        JavaCollection cust = (JavaCollection) context.getBean("javaCollection");
        System.out.println(cust.toString());
    }
}
