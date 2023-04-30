package com.wztedu.spring.proxy2;

public class Ship implements Vehicle {
    @Override
    public void run() {
        // System.out.println("交通工具开始运行了");
        System.out.println("大轮船在水上 running");
        // System.out.println("交通工具停止运行了");
    }

    @Override
    public String fly(int height) {
        System.out.println("轮船改进后可以飞翔 高度是= " + height);
        return "轮船改进后可以飞翔 高度是= " + height;
    }
}
