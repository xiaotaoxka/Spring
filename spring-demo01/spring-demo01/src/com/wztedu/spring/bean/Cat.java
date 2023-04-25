package com.wztedu.spring.bean;

public class Cat {
    private Integer id;
    private String name;

    public Cat() {
        // System.out.println("Cat()构造器 被执行");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // @Override
    // public String toString() {
    //     return "Cat{" +
    //             "id=" + id +
    //             ", name='" + name + '\'' +
    //             '}';
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
