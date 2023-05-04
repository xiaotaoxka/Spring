package com.wztedu.spring.aop.proxy3;

public class SmartDog implements SmartAnimalable {
    @Override
    public float getSum(float i, float j) {
        // System.out.println("方法执行开始-日志-方法名-getSum-参数" + i + " " + j);
        float result = i + j;
        // System.out.println("方法内部打印 result = " + result);
        // System.out.println("方法执行正常结束-日志-方法名-getSum-结果 result= " + result);
        return result;
    }

    @Override
    public float getSub(float i, float j) {
        // System.out.println("方法执行开始-日志-方法名-getSub-参数" + i + " " + j);
        float result = i - j;
        // System.out.println("方法内部打印 result = " + result);
        // System.out.println("方法执行正常结束-日志-方法名-getSub-结果 result= " + result);
        return result;
    }
}
