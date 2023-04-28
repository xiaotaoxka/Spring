package com.wztedu.spring.test;

import com.wztedu.spring.bean.*;
import com.wztedu.spring.component.MyComponent;
import com.wztedu.spring.component.UserAction;
import com.wztedu.spring.component.UserDao;
import com.wztedu.spring.component.UserService;
import com.wztedu.spring.service.MemberServiceImpl;
import com.wztedu.spring.web.OrderAction;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {

    @Test
    public void setProByAutowired() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans06.xml");

        UserAction userAction = ioc.getBean("userAction", UserAction.class);
        UserService userService = ioc.getBean("userService", UserService.class);
        System.out.println("userService= " + userService);
        // System.out.println("userAction= " + userAction);
        userAction.sayOk();
    }

    // 通过注解来配置bean
    @Test
    public void setBeanByAnnotation() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans05.xml");

        UserDao userDao = ioc.getBean(UserDao.class);
        // 在默认情况下，注解标识的类创建对象后，在容器中，id为类名的首字母小写
        UserDao wztDao = ioc.getBean("wztDao", UserDao.class);
        UserService userService = ioc.getBean(UserService.class);
        UserAction userAction = ioc.getBean(UserAction.class);
        MyComponent myComponent = ioc.getBean(MyComponent.class);

        System.out.println("userDao= " + userDao);
        System.out.println("wztDao= " + wztDao);
        System.out.println("userService= " + userService);
        System.out.println("userAction= " + userAction);
        System.out.println("myComponent= " + myComponent);

        System.out.println("ok~~~");
    }

    // 通过 Spring EL 对属性进行赋值
    @Test
    public void setBeanBySpEL() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans04.xml");

        SpELBean spELBean = ioc.getBean("spELBean", SpELBean.class);
        System.out.println("spELBean= " + spELBean);
    }

    // 通过自动装配给bean赋值
    @Test
    public void setBeanByAutowire() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans03.xml");

        OrderAction orderAction = ioc.getBean("orderAction", OrderAction.class);

        // 验证是否自动装配上 OrderAction
        System.out.println(orderAction.getOrderService());

        // 验证是否自动装配上 OrderDao
        System.out.println(orderAction.getOrderService().getOrderDao());
    }

    // 通过属性文件给bean赋值
    @Test
    public void setBeanByFile() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans03.xml");

        Monster monster1000 = ioc.getBean("monster1000", Monster.class);
        System.out.println("monster1000= " + monster1000);
    }


    @Test
    public void beanPostProcessor() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans02.xml");

        House house = ioc.getBean("house", House.class);
        House house02 = ioc.getBean("house02", House.class);
        System.out.println("使用house= " + house);
        System.out.println("使用house02= " + house02);
    }

    // 测试 bean 的生命周期
    @Test
    public void testBeanLife() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        House house = ioc.getBean("house", House.class);
        System.out.println("使用 house " + house);

        // 关闭容器
        ((ClassPathXmlApplicationContext) ioc).close();
    }

    // 测试 Scop
    @Test
    public void testBeanScop() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Cat cat = ioc.getBean("cat", Cat.class);
        Cat cat2 = ioc.getBean("cat", Cat.class);
        Cat cat3 = ioc.getBean("cat", Cat.class);

        System.out.println("cat= " + cat);
        System.out.println("cat2= " + cat2);
        System.out.println("cat3= " + cat3);
    }

    // 测试 bean 创建顺序
    @Test
    public void testBeanByCreate() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("ok~~~");
    }

    // 配置 bean 通过继承
    @Test
    public void setBeanByExtends() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Monster monster11 = ioc.getBean("monster11", Monster.class);
        System.out.println("monster11= " + monster11);

        Monster monster13 = ioc.getBean("monster13", Monster.class);
        System.out.println("monster13= " + monster13);
    }

    // 通过FactoryBean获取 bean
    @Test
    public void setBeanByFactoryBean() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Monster my_monster05 = ioc.getBean("my_monster05", Monster.class);
        System.out.println("my_monster05= " + my_monster05);
    }

    // 通过实例工厂获取 bean
    @Test
    public void setBeanByInstanceFactory() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Monster my_monster02 = ioc.getBean("my_monster02", Monster.class);
        System.out.println("my_monster02= " + my_monster02);
    }

    // 通过静态工厂来获取一个 bean
    @Test
    public void setBeanByStaticFactory() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Monster my_monster01 = ioc.getBean("my_monster01", Monster.class);
        System.out.println("my_monster01= " + my_monster01);
    }

    // 给属性进行级联操作
    @Test
    public void setBeanByRelation() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Emp emp = ioc.getBean("emp", Emp.class);
        System.out.println("emp= " + emp);
    }

    // 使用 util:list名称空间给属性赋值
    @Test
    public void setBeanByUtil() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        BookStore bookstore = ioc.getBean("bookStore", BookStore.class);
        System.out.println("bookstore= " + bookstore);
    }


    // 给集合数组属性进行赋值
    @Test
    public void setBeanByCollection() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Master master =
                ioc.getBean("master", Master.class);

        System.out.println(master);
    }

    // 通过内部的bean设置属性
    @Test
    public void setBeanByPro() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        MemberServiceImpl memberService2 =
                ioc.getBean("memberService2", MemberServiceImpl.class);

        memberService2.add();
    }

    // 通过 ref 来设置 bean属性
    @Test
    public void setBeanByRef() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        MemberServiceImpl memberService =
                ioc.getBean("memberService", MemberServiceImpl.class);

        memberService.add();
    }


    // 通过 Bean 的类型来获取对象
    @Test
    public void getBeanByType() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        // 直接传入 class 对象/类型
        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean= " + bean);
    }

    // 通过构造器来设置属性
    @Test
    public void setBeanByConstructor() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Monster monster03 = ioc.getBean("monster03", Monster.class);
        System.out.println("monster03= " + monster03);
    }

    // 通过 p 名称空间来设置属性
    @Test
    public void setBeanByP() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        Monster monster06 = ioc.getBean("monster06", Monster.class);

        System.out.println("monster06=" + monster06);
    }

    @Test
    public void getMonster() {

        // 1. 创建容器 ApplicationContext
        // 2. 该容器和配置文件关联
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        // 3. 通过 getBean获取对应的对象
        // 默认返回 Object, 但是运行类型 Monster
        // Object monster01 =  ioc.getBean("monster01");

        // 强制类型转换
        Monster monster01 = (Monster) ioc.getBean("monster01");
        // 输出
        System.out.println("Monster= " + monster01);
        System.out.println("属性name= " + monster01.getName() + "monster01Id= " + monster01.getMonsterId());

        // 5. 也可以在获取时，直接指定 Class 对象
        Monster monster011 = ioc.getBean("monster01", Monster.class);
        System.out.println("Monster= " + monster011);
        System.out.println("属性name= " + monster011.getName() + "monster01Id= " + monster011.getMonsterId());

        // 查看容器注入了哪些 bean 对象,会输出 bean 的 id

        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("ok");
    }
}
