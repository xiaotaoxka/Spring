package com.wztedu.spring.aop.proxy3;

import java.lang.reflect.Method;
import java.util.Arrays;

public class WztAop {
    public static void before(Object proxy, Method method, Object[] args) {
        System.out.println("WztAop-before-方法执行前-日志-方法名-" + method.getName() + "-参数-" +
                Arrays.asList(args));  // 从 aop的角度来看，就是一个横切关注点-前置通知
    }

    public static void after(Method method, Object result) {
        // 从 aop看，也是一个横切关注点-返回通知
        System.out.println("WztAop-after-方法正常执行后-日志-方法名-" + method.getName() + " result = " + result);
    }
}
