package com.wztedu.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 这是一个后置处理器，需要实现 BeanPostProcessor 接口
 *
 * @author xiaotao
 * @version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 什么时候被调用：在 Bean init方法前被调用
     *
     * @param bean     传入的在 ioc 容器中配置/配置的那个bean
     * @param beanName 传入的在ioc容器中创建/配置Bean的id
     * @return Object 程序员对传入的 bean 进行修改/处理 返回
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization()...bean=" + bean + " " + beanName);

        // 如果类型是 House 的统一改成 上海豪宅
        // 对多个对象进行 处理/编程 => 切面编程
        if (bean instanceof House) {
            ((House) bean).setName("上海豪宅");
        }

        return bean;
    }

    /**
     * 什么时候被调用：在 Bean init方法后被调用
     *
     * @param bean     传入的在 ioc 容器中配置/配置的那个bean
     * @param beanName 传入的在ioc容器中创建/配置Bean的id
     * @return Object 程序员对传入的 bean 进行修改/处理 返回
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization()...bean=" + bean + " " + beanName);
        return bean;
    }
}
