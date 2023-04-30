package com.wztedu.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 可以返回一个动态代理对象，可以执行 SmartDog中的方法
 *
 * @author xiaotao
 * @version 1.0
 */
public class MyProxyProvider {

    // 定义一个我们要执行的目标对象，该对象需要实现 SmartAnimalable
    private SmartAnimalable target_obj;

    public MyProxyProvider(SmartAnimalable target_obj) {
        this.target_obj = target_obj;
    }

    // 方法，可以返回代理对象，该代理对象可以执行目标对象
    public SmartAnimalable getProxy() {
        // 1， 先得到类加载器/对象

        ClassLoader classLoader = target_obj.getClass().getClassLoader();

        // 2. 要得到执行目标对象的接口信息
        Class<?>[] interfaces = target_obj.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("方法执行前-日志-方法名-" + method.getName() + "-参数-" +
                            Arrays.asList(args));  // 从 aop的角度来看，就是一个横切关注点-前置通知

                    result = method.invoke(target_obj, args);

                    // 从 aop看，也是一个横切关注点-返回通知
                    System.out.println("方法正常执行后-日志-方法名-" + method.getName() + " result = " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    // 如果反射执行方法时出现异常就会进入到 catch{}
                    // 从 aop来看，也是一个横切关注点-异常通知
                    System.out.println("方法执行异常-日志-方法名- " + method.getName() + "-异常信息= " + e.getClass().getName());
                } finally {
                    // 不管是否出现异常最终都会执行到 finally{}
                    // 从 aop的角度看，也是一个横切关注点-最终通知
                    System.out.println("方法最终结束-日志-方法名-" + method.getName());
                }
                return result;

            }
        };

        // 创建代理对象
        SmartAnimalable proxyInstance = (SmartAnimalable) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxyInstance;
    }
}

