package com.wztedu.spring.bean;

public class House {
    private String name;

    public House() {
        System.out.println("House() 构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("House setName()..." + name);
        this.name = name;
    }

    // 1. 这个方法是程序员来编写的
    // 2. 根据自己的业务逻辑来写
    public void init() {
        System.out.println("House init()..");
    }

    // 1. 这个方法是程序员来编写的
    // 2. 根据自己的业务逻辑来写
    public void destory() {
        System.out.println("House destory()..");
    }
}