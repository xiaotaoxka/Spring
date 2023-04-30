package com.wztedu.spring.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * VehicleProxyProvider 该类返回一个代理对象
 *
 * @author xiaotao
 * @version 1.0
 */
public class VehicleProxyProvider {

    // 定义一个属性
    // target_vehicle 表示真正执行的对象
    // 该对象实现了 Vehicle接口
    private Vehicle target_vehicle;

    // 构造器
    public VehicleProxyProvider(Vehicle target_vehicle) {
        this.target_vehicle = target_vehicle;
    }

    // 编写一个方法, 返回一个代理对象
    // 1. 这个方法非常重要
    public Vehicle getProxy() {

        // 得到一个类加载器
        ClassLoader classLoader
                = target_vehicle.getClass().getClassLoader();

        // 得到要代理的对象/被执行对象的接口信息, 底层通过接口来调用
        Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();

        // 创建 InvocationHandler 对象
        // 因为 InvocationHandler 是接口, 所以我们可以通过匿名对象的方式来创建该对象

        InvocationHandler invocationHandler = new InvocationHandler() {

            /**
             * invoke 方法是将来我们在执行 target_vehicle的方法时，会调用到
             * @param proxy 表示代理对象
             *
             * @param method 就是通过代理对象调用方法时，的那个方法
             *
             * @param args 表示调用 代理对象.方法名(XX) 传入的参数
             *
             * @return 表示 代理对象.run(XX)  执行后的结果
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("交通工具开始运行了");
                // 这里是反射基础
                Object result = method.invoke(target_vehicle, args);
                System.out.println("交通工具停止运行了");

                return result;
            }
        };

        /*
         public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
         */

        /*
        1. Proxy.newProxyInstance() 可以返回一个代理对象
        2. ClassLoader loader: 类的加载器
        3. Class<?>[] interfaces 就是将来要代理的对象的接口信息
        4. InvocationHandler h 调用处理器/对象 有一个非常重要的方法 invoke
         */
        Vehicle proxyInstance =
                (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return proxyInstance;
    }
}
