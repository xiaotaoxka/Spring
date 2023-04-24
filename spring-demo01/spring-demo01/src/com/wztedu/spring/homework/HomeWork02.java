package com.wztedu.spring.homework;

import com.wztedu.spring.bean.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HomeWork02 {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("car_beans.xml");

        Car car01 = ioc.getBean("car01", Car.class);
        System.out.println("car01= " + car01);
        System.out.println("car01.id= " + car01.getId());
        System.out.println("car01.name= " + car01.getName());
        System.out.println("car01.price= " + car01.getPrice());

    }
}
