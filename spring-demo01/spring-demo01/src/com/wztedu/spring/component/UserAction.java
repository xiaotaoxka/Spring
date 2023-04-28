package com.wztedu.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author xiaotao
 * @version 1.0
 * @Controller 标识类是一个控制器 Controller,通常这个类是一个Servlet
 */

@Controller
public class UserAction {
    // @Autowired
    // 1) 在 IOC 容器中查找待装配的组件的类型，如果有唯一的 bean 匹配，则使用该 bean 装配
    // 2) 如待装配的类型对应的 bean 在 IOC 容器中有多个，则使用待装配的属性的属性名作为 id 值再进行查找, 找到就装配，找不到就抛异
    @Resource(name = "userService")
    private UserService userService;

    public void sayOk() {
        System.out.println("UserAction 的 sayOk");
        userService.hi();
    }
}
