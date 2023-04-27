package com.wztedu.spring.annotation;


import com.wztedu.spring.component.MyComponent;
import com.wztedu.spring.component.UserAction;
import com.wztedu.spring.component.UserDao;
import com.wztedu.spring.component.UserService;

public class WztSpringApplicationContextTest {

    public static void main(String[] args) {

        WztSpringApplicationContext ioc
                = new WztSpringApplicationContext(WztSpringConfig.class);
        UserAction userAction = (UserAction) ioc.getBean("userAction");
        System.out.println("userAction= " + userAction);

        MyComponent myComponent = (MyComponent) ioc.getBean("wztComponent");
        System.out.println("myComponent= " + myComponent);

        UserDao userDao = (UserDao) ioc.getBean("userDao");
        System.out.println("userDao= " + userDao);

        UserService userService = (UserService) ioc.getBean("userService");
        System.out.println("userService= " + userService);
        System.out.println("Ok~~~");

    }
}
